package bq_resume.parking_lot_design;

import bq_resume.parking_lot_design.vehicle.Vehicle;
import bq_resume.parking_lot_design.vehicle.VehicleType;

public class ParkingSpot {
	
	private final String id;
	private Vehicle parkedVehicle;
	private final VehicleType spotType;
	
	public ParkingSpot(final String id, final VehicleType vehicleType) {
		this.id = id;
		this.spotType = vehicleType;
	}
	
	public boolean canPark(final Vehicle vehicle) {
		
		if (!isEmpty()) {
			return false;
		}
		
		return spotType.getSize() >= vehicle.getType().getSize();
	}
	
	public synchronized boolean goPark(final Vehicle v) {
		if (canPark(v)) {
			parkedVehicle = v;
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		return parkedVehicle == null;
	}
	
	public synchronized boolean vehiclePark(final Vehicle vehicle) {
		if (!canPark(vehicle)) {
			return false;
		}
		parkedVehicle = vehicle;
		vehicle.setSpot(this);
		return true;
	}
}
