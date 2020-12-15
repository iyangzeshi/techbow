package bq_resume.airbnb;

import bq_resume.airbnb.GeoLocation.Address;
import java.util.List;

/**
 * Created by FLK on 2020-01-01.
 */
public class User {
    private final String userId;
    private UserType type;

    public User(final String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserType(final UserType userType){
        this.type = userType;
    }

    public List<House> searchHouse(final Address address){
        final HouseManager houseManager = HouseManager.getInstance();
        return houseManager.searchByAddress(address);
    }

    public List<House> searchHouse(final int zipcode){
        final HouseManager houseManager = HouseManager.getInstance();
        return houseManager.searchByZipcode(zipcode);
    }
}
