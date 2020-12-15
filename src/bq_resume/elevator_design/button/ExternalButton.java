package bq_resume.elevator_design.button;

import bq_resume.elevator_design.Direction;
import bq_resume.elevator_design.ElevatorSystem;
import bq_resume.elevator_design.InvalidRequestException;
import bq_resume.elevator_design.request.ExternalRequest;

/**
 * Created by FLK on 2020-06-20.
 */
public class ExternalButton extends Button{

    private final ElevatorSystem elevatorSystem;

    public ExternalButton(final String id, final int levelNumber, final ElevatorSystem elevatorSystem) {
        super(id, levelNumber);
        this.elevatorSystem = elevatorSystem;
    }

    public void sendUpRequest() throws InvalidRequestException {
        elevatorSystem.handleRequest(new ExternalRequest(levelNumber, Direction.UP));
    }

    public void sendDownRequest() throws InvalidRequestException {
        elevatorSystem.handleRequest(new ExternalRequest(levelNumber, Direction.DOWN));
    }

}
