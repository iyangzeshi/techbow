package mock.parkingLotByFrankFang;

//Project: techbow
//Package: mock
//ClassName: ParkingSpot
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-24 星期四 19:36
public class ParkingSpot {
	private String id;
	private Vehicle ParkingVehicle;
	private VehicleType spotType;
	
	public ParkingSpot(String id, VehicleType spotType) {
		this.id = id;
		this.spotType = spotType;
	}
	
	public boolean canPark(Vehicle vehicle) {
		if (ParkingVehicle == null) {
			return true;
		}
		return spotType.getSize() >= vehicle.getType().getSize();
	}
	
	public boolean isEmpty() {
		return ParkingVehicle == null;
	}
	
}
