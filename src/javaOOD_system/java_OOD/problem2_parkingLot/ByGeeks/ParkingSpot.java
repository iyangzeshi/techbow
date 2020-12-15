package javaOOD_system.java_OOD.problem2_parkingLot.ByGeeks;

//Project: techbow
//Package: javaOODSystem.javaOOD.parkingLot.ByGeeks
//ClassName: ParkingSpot
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:03
public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int lane;
	private int spotNumber;
	private Level level;
	
	public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {
		level = lvl;
		lane = r;
		spotNumber = n;
		spotSize = s;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle vehicle) {
		//check if the spot is big enough and is available
		return isAvailable() && vehicle.canFitInSpot(this);
	}
	
	public boolean park(Vehicle v) {
		if (!canFitVehicle(v))
			return false;
		
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}
	
	public int getLane() {
		return lane;
	}
	
	public int getSpotNumber() {
		return spotNumber;
	}
	
	public VehicleSize getSize() {
		return spotSize;
	}
	
	public void removeVehicle() {
		level.spotFreed();
		vehicle = null;
	}
}
