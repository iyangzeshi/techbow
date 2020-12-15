package bq_resume.parking_lot_design.parkingRule;

import bq_resume.parking_lot_design.vehicle.Vehicle;

/**
 * Created by FLK on 2020-06-27.
 */
public class TechbowStudentRule implements IParkingRule {
    @Override
    public boolean isValid(Vehicle vehicle) {

        //Only valid for Techbow Student

        return false;
    }
}
