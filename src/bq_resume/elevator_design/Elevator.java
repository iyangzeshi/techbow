package bq_resume.elevator_design;

import static java.awt.Event.DOWN;
import static java.awt.Event.UP;

import bq_resume.elevator_design.button.InternalButton;
import bq_resume.elevator_design.request.ExternalRequest;
import bq_resume.elevator_design.request.Request;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Elevator {
    
    private final String id;
    
    private final int capacity;
    
    /**
     * 1 --> 5 --> 3 --> 6 --> 4
     * <p>
     * 1.  Queue - FIFO 2.  1 --> 5 --> 6 --> 4 --> 3 Up: minHeap Down: maxHeap
     */
    
    private final PriorityQueue<Integer> upTasks; // minHeap
    private final PriorityQueue<Integer> downTasks; // maxHeap
    private final List<InternalButton> internalButtons;
    private final int MAX_FLOOR;
    private Direction currentDirection;
    private int currentLevelNumber;
    
    public Elevator(final String id, final int capacity, int MAX_FLOOR) {
        this.id = id;
        this.capacity = capacity;
        this.MAX_FLOOR = MAX_FLOOR;
        internalButtons = new ArrayList<>();
        upTasks = new PriorityQueue<>();
        downTasks = new PriorityQueue<>((r1, r2) -> (r2 - r1));
        initInternalButtons();
    }
    
    public Direction getCurrentDirection() {
        return currentDirection;
    }
    
    public int getCurrentLevelNumber() {
        return currentLevelNumber;
    }
    
    private void initInternalButtons() {
        for (int i = 1; i <= MAX_FLOOR; i++) {
            internalButtons.add(new InternalButton(id + "-" + i, i, this));
        }
    }
    
    public boolean handleInternalRequest(final Request request) {
        //Check Edge case
        if (!checkValidRequest(request)) {
            return false;
        }
        
        // Compare the request with current Level, if larger -> up request, else down Request
        final int requestLevelNumber = request.getLevelNumber();
        
        //Handle the task according to the current level
        if (requestLevelNumber > currentLevelNumber && currentLevelNumber != DOWN) {
            upTasks.offer(requestLevelNumber);
            return true;
        } else if (requestLevelNumber < currentLevelNumber && currentLevelNumber != UP) {
            downTasks.offer(requestLevelNumber);
            return true;
        }
        
        return false;
    }
    
    /**
     * @param externalRequest
     * @throws InvalidRequestException
     */
    public void handleExternalRequest(final ExternalRequest externalRequest) throws
            InvalidRequestException {
        if (!checkValidRequest(externalRequest)) {
            return;
        }
        
        final int requestLevelNumber = externalRequest.getLevelNumber();
        
        if (externalRequest.getDirection() == Direction.UP) { // 电梯在向上走的时候
            if (externalRequest.getLevelNumber() > currentLevelNumber
                    && currentDirection != Direction.DOWN) {
                upTasks.offer(requestLevelNumber);
            } else {
                throw new InvalidRequestException("This Up Request is Invalid"); // 更方便debug
            }
        } else if (externalRequest.getDirection() == Direction.DOWN) {
            if (externalRequest.getLevelNumber() < currentLevelNumber && currentLevelNumber != UP) {
                downTasks.offer(requestLevelNumber);
            } else {
                throw new InvalidRequestException("This Down Request is Invalid"); // 更方便debug
            }
        }
    }
    
    private boolean checkValidRequest(Request request) {
        if (request == null) {
            return false;
        }
        
        final Integer requestLevelNumber = request.getLevelNumber();
        
        if (requestLevelNumber < 1 || requestLevelNumber > MAX_FLOOR) {
            //Edge cases
            
            // Log.info("Elevator: The request is invalid");
            return false;
        } else if (requestLevelNumber == currentLevelNumber
                || upTasks.contains(requestLevelNumber)
                || downTasks.contains(requestLevelNumber)) {
            // Duplicate cases
            // Log.info("Elevator: The request is duplicate");
            return false;
        }
        
        return true;
    }
    
    //Elevator Move Up
    public void moveUp() {
        currentDirection = Direction.UP;
        
        while (!upTasks.isEmpty()) {
            currentLevelNumber = upTasks.poll();
        }
        
        currentDirection = Direction.STOP;
    }
    
    //Elevator Move down
    public void moveDown() {
        currentDirection = Direction.DOWN;
        while (!downTasks.isEmpty()) {
            currentLevelNumber = downTasks.poll();
        }
        
        currentDirection = Direction.STOP;
    }
    
    public void run() {
        if (currentDirection == Direction.STOP) {
            while (!upTasks.isEmpty()) {
                moveUp();
            }
            
            while (!downTasks.isEmpty()) {
                moveDown();
            }
        }
    }
    
}