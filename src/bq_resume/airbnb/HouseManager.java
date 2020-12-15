package bq_resume.airbnb;

import bq_resume.airbnb.GeoLocation.Address;
import java.util.ArrayList;
import java.util.List;

/*
  Created by FLK on 2020-01-01.
  singleton
 */
/*** singleton ***/
public class HouseManager {

    private static HouseManager instance = null;

    private HouseManager() {
    }

    public static HouseManager getInstance(){
        if(instance == null) {
            synchronized (HouseManager.class) {
                if (instance == null) {
                    instance = new HouseManager();
                }
            }
        }

        return instance;
    }

    public List<House> searchByAddress(final Address address) {
        //Do some query operation or service call
        return new ArrayList<>();
    }

    public List<House> searchByZipcode(final int zipcode) {
        //Do some query operation or service call
        return new ArrayList<>();
    }
}
