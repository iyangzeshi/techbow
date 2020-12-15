package javaOOD_system.java_OOD.problem2_parkingLot.ByGeeks;

import java.util.ArrayList;

//Project: techbow
//Package: javaOODSystem.javaOOD.parkingLot.ByGeeks
//ClassName: Vehicle
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:02
public abstract class Vehicle{
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;
	protected String Company;
	
	public int getSpotsNeeded(){
		return spotsNeeded;
	}
	public VehicleSize getSize(){
		return size;
	}
	
	public void parkInSpot(ParkingSpot s){
		parkingSpots.add(s);
	}
	
	public void clearSpots(){
		//remove car from spot, and notify spot that it's gone
		for (int i = 0; i < parkingSpots.size(); i++){
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();
	}
	
	public abstract boolean canFitInSpot(ParkingSpot spot);
}
