package javaOOD_system.java_OOD.problem2_parkingLot.byLaoliu;

import javaOOD_system.java_OOD.problem2_parkingLot.byLaoliu.veihicle.Vehicle;

//Project: techbow
//Package: javaOODSystem.javaOOD.parkingLot.byLaoliu
//ClassName: ParkingSpot
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:09
public class ParkingSpot {
	
	// fields
	private int id;
	private Vehicle cur;
	private final VehicleType type;
	
	// methods
	public ParkingSpot(VehicleType type) {
		this.type = type;
		cur = null;
	}
	
	public boolean canPark(final Vehicle v) {
		// corner case
		return cur == null && this.type.compareTo(v.getType()) >= 0;
	}
	
	// synchronized 很重要
	public synchronized boolean goPark(final Vehicle v) {
		if (canPark(v)) {
			cur = v;
			return true;
		}
		return false;
	}
	
	public Vehicle leavePark() {
		// corner case
		Vehicle temp = cur;
		cur = null;
		return temp;
	}
}