package javaOOD_system.java_OOD.problem2_parkingLot.byLaoliu;

import javaOOD_system.java_OOD.problem2_parkingLot.byLaoliu.veihicle.Vehicle;

//Project: techbow
//Package: javaOODSystem.javaOOD.parkingLot.byLaoliu
//ClassName: Level
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:08
public class ParkingLevel { //不要过度design
	
	// fields
	private int id;
	private final int floor;
	private final ParkingSpot[] spots;
	
	// methods
	public ParkingLevel(int floor, int BusCap, int CarCap, int MotoCap) {
		this.floor = floor;
		spots = new ParkingSpot[BusCap + CarCap + MotoCap];
		for (int i = 0; i < spots.length; i++) {
			if (i < BusCap) {
				spots[i] = new ParkingSpot(VehicleType.BUS);
			} else if (i >= BusCap && i < BusCap + CarCap) {
				spots[i] = new ParkingSpot(VehicleType.CAR);
			} else {
				spots[i] = new ParkingSpot(VehicleType.MOTO);
			}
		}
	}
	
	public boolean canPark(final Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.canPark(v)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean goPark(final Vehicle v) {
		if (!canPark(v)) {
			return false;
		}
		for (ParkingSpot spot : spots) {
			if (spot.canPark(v)) { // not good way → spot.goPark(v)
				spot.goPark(v);
				return true;
			}
		}
		return false; // concurrency or compiler
	}
	
	public int numOfAvilableSpot(final Vehicle v) {
		int count = 0;
		for (ParkingSpot spot : spots) {
			if (spot.canPark(v)) {
				count++;
			}
		}
		return count;
	}
}