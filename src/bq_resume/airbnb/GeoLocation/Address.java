package bq_resume.airbnb.GeoLocation;

/**
 * Created by FLK on 2020-01-01.
 */
public class Address {
	
	final String streetName;
	final String city;
	final State state;
	final int zipcode; // 这个最重要
	
	public Address(final String streetName, final String city, final State state,
			final int zipcode) {
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	// Creating toString
	@Override
	public String toString() {
		return String.format("Address [streetName=%s, city=%s, state=%s, zipcode=%s",
				streetName, city, state.toString(), zipcode);
	}
}
