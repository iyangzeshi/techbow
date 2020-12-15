package javaOOD_system.java_OOD.problem2_parkingLot.byLaoliu.veihicle;

import javaOOD_system.java_OOD.problem2_parkingLot.byLaoliu.VehicleType;

//Project: techbow
//Package: javaOODSystem.javaOOD.parkingLot.byLaoliu
//ClassName: Vehicle
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:07
public abstract class Vehicle {
	private int id;
	private VehicleType type; // protected, final
	
	public Vehicle(VehicleType type) {
		this.type = type;
	}
	
	public VehicleType getType() {
		return type;
	}
	
	public void setType(VehicleType type) {
		this.type = type;
	}
}