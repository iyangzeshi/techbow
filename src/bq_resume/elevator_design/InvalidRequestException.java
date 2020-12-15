package bq_resume.elevator_design;

/**
 * Created by FLK on 2020-06-20.
 */
public class InvalidRequestException extends Exception {
    public InvalidRequestException(String message){
        super(message);
    }
}
