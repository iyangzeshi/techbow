package bq_resume.elevator_design;

import bq_resume.elevator_design.request.ExternalRequest;

/**
 * Created by FLK on 2020-06-20.
 */
public class ElevatorSystem {
    public int MAX_FLOOR = 20;
    public int elevatorNum = 3;
    public Elevator[] elevators;

    public ElevatorSystem(int MAX_FLOOR, int elevatorNum) {
        this.MAX_FLOOR = MAX_FLOOR;
        this.elevatorNum = elevatorNum;
        elevators = new Elevator[elevatorNum];
    }

    public void handleRequest(ExternalRequest externalRequest) throws InvalidRequestException {
        if (externalRequest.getDirection() == Direction.UP) {
            Elevator highElevator = null;
            for (int i = 0; i < elevatorNum; i++) {
                if (elevators[i].getCurrentDirection() == externalRequest.getDirection() && elevators[i].getCurrentLevelNumber() < externalRequest.getLevelNumber()) {
                    if (highElevator == null) {
                        highElevator = elevators[i];
                    } else if (elevators[i].getCurrentLevelNumber() > highElevator.getCurrentLevelNumber()) {
                        highElevator = elevators[i];
                    }
                }
            }
            highElevator.handleExternalRequest(externalRequest);
        }

        if (externalRequest.getDirection() == Direction.DOWN) {
            Elevator lowElevator = null;
            for (int i = 0; i < elevatorNum; i++) {
                if (elevators[i].getCurrentDirection() == externalRequest.getDirection() && elevators[i].getCurrentLevelNumber() > externalRequest.getLevelNumber()) {
                    if (lowElevator == null) {
                        lowElevator = elevators[i];
                    } else if (elevators[i].getCurrentLevelNumber() < lowElevator.getCurrentLevelNumber()) {
                        lowElevator = elevators[i];
                    }
                }
            }
        }

    }
}
