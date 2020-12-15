package javaOOD_system.java_OOD.problem2_parkingLot.ByGeeks;

//Project: techbow
//Package: javaOODSystem.javaOOD.parkingLot.ByGeeks
//ClassName: Motorcycle
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:04
public class Motorcycle extends Vehicle{
	public Motorcycle(String licensePlate, String Company){
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
		this.licensePlate = licensePlate;
		this.Company = Company;
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		//checks if the spot is a compact, motorcycle or a large
		
		return spot.getSize() == VehicleSize.CarSize || spot.getSize() == VehicleSize.Motorcycle;
		
	}
}
