package javaOOD_system.java_OOD.problem2_parkingLot.ByGeeks;

//Project: techbow
//Package: javaOODSystem.javaOOD.parkingLot.ByGeeks
//ClassName: Car
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:04
public class Car extends Vehicle{
	public Car(String licensePlate, String Company){
		spotsNeeded = 1;
		size = VehicleSize.CarSize;
		this.licensePlate = licensePlate;
		this.Company = Company;
	}
	
	public boolean canFitInSpot(ParkingSpot spot){
		//checks if the spot is for a car
		return spot.getSize() == VehicleSize.CarSize;
	}
}
