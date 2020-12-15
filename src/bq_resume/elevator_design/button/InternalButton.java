package bq_resume.elevator_design.button;

import bq_resume.elevator_design.Elevator;
import bq_resume.elevator_design.request.Request;

/**
 * Created by FLK on 2020-06-20.
 */
public class InternalButton extends Button{

    private final Elevator elevator;

    public InternalButton(String id, int levelNumber, final Elevator elevator) {
        super(id, levelNumber);
        this.elevator = elevator;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void sendRequest() {
        //Call API from Elevator to handle the request
        elevator.handleInternalRequest(new Request(levelNumber));
    }

}
