package javaOOD_system.java_OOD.problem2_parkingLot.byLaoliu;

//Project: techbow
//Package: javaOODSystem
//ClassName: ParkingLot
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 19:19

import javaOOD_system.java_OOD.problem2_parkingLot.byLaoliu.veihicle.Vehicle;

public class ParkingLot {
	
	// fields
	private final ParkingLevel[] parkingLevels; // 很重要
	
	public ParkingLot(int[][] design) {
		int num = 3;
		parkingLevels = new ParkingLevel[num];
		for (int i = 0; i < num; i++) {
			parkingLevels[i] = new ParkingLevel(i, 1, 2, 3); // design[][] → BQ
		}
	}
	
	public boolean canPark(final Vehicle v) {
		for (ParkingLevel lev : parkingLevels) {
			if (lev.canPark(v)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean goPark(final Vehicle v) {
		if (!canPark(v)) {
			return false;
		}
		for (ParkingLevel lev : parkingLevels) {
			if (lev.canPark(v)) { // bad → lev.goPark(v);
				lev.goPark(v);
				return true;
			}
		}
		return false;
	}
}