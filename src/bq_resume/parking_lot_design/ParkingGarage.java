package bq_resume.parking_lot_design;

import bq_resume.parking_lot_design.vehicle.Vehicle;

public class ParkingGarage  {
    private final String id;
    private final int levelNum;
    private final int size;
    private int emptySpot;

    private final ParkingLevel[] parkingLevels;

    private final static int MOTO_NUMBER_IN_LEVEL = 20;
    private final static int COMPACT_NUMBER_IN_LEVEL = 100;
    private final static int BUS_NUMBER_IN_LEVEL = 10;
    
    public ParkingGarage(final String id, final int levelNum) {
        this.id = id;
        this.levelNum = levelNum;
        
        parkingLevels = new ParkingLevel[levelNum];
        
        for (int i = 0; i < levelNum; i++) {
            parkingLevels[i] = new ParkingLevel("" + i, MOTO_NUMBER_IN_LEVEL,
                    COMPACT_NUMBER_IN_LEVEL, BUS_NUMBER_IN_LEVEL, this);
        }
        
        size = levelNum * MOTO_NUMBER_IN_LEVEL * COMPACT_NUMBER_IN_LEVEL * BUS_NUMBER_IN_LEVEL;
        emptySpot = size;
    }
    
    public boolean canPark(final Vehicle vehicle) {

        for(ParkingLevel parkingLevel : parkingLevels){
            if (parkingLevel.canPark(vehicle)) return true;
        }

        return false;
    }
    
    public boolean goPark(final Vehicle vehicle, final int level) {
        if (level < 0 || level >= levelNum) {
            return false;
        }
        if (parkingLevels[level].canPark(vehicle)) {
            parkingLevels[level].parkVehicle(vehicle);
            emptySpot--;
            return true;
        }
        return false;
    }

    public void vehicleLeavePark(){
        emptySpot++;
    }

    public int getEmptySpotNum() {
        return emptySpot;
    }

    public int getSize() {
        return size;
    }
}


