package javaOOD_system.java_OOD.problem2_parkingLot.byLaoliu;

//Project: techbow
//Package: javaOODSystem.javaOOD.parkingLot.byLaoliu
//ClassName: VehicleType
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:07
public enum VehicleType {
	MOTO(1),
	CAR(2),
	BUS(3);
	
	private final int size;
	
	VehicleType(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
}
