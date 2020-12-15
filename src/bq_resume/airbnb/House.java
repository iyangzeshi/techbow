package bq_resume.airbnb;

import bq_resume.airbnb.GeoLocation.Address;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by FLK on 2020-01-01.
 */
public class House {
	
	final String id;
	final Address address;
	final int capacity;
	final String ownerId;
	private BuildingType houseType;
	final Set<String> reservations;
	
	public House(final String id, final Address address, final int capacity,
            final String ownerId) {
		this.id = id;
		this.address = address;
		this.capacity = capacity;
		this.ownerId = ownerId;
		reservations = new TreeSet<>();
	}
	
	public Address getAddress() {
		return address;
	}
	
	public String getId() {
		return id;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public String getOwnerId() {
		return ownerId;
	}
	
	public Set<String> getReservations() {
		return reservations;
	}
	
	public void addReservations(final String reservationId) {
		reservations.add(reservationId);
	}
	
}
