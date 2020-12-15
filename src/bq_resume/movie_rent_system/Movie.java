package bq_resume.movie_rent_system;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Movie {
    private String movieId;

    private Set<License> licenses;

    //Key: actual license
    private Set<License> availableLicenseSet;

    public Movie(final String movieId){
        this.movieId = movieId;
        licenses = new HashSet<>();
        availableLicenseSet = new HashSet<>();
    }

    public void addNewLicense(List<License> licenses){
        this.licenses.addAll(licenses);
        availableLicenseSet.addAll(licenses);
    }

    public License rent(final String userId, final long startTime, final long endTime){
        updateLicense();
        License license = null;

        for(License l : availableLicenseSet){
            license = l;
            availableLicenseSet.remove(l);
            break;
        }

        license.rent(userId, startTime, endTime);

        return license;
    }

    public void updateLicense(){
        for(License license : licenses){
            if(needUpdate(license)){
                license.release();
                availableLicenseSet.add(license);
            }
        }
    }

    public int getAvailableListSize(){
        updateLicense();
        return availableLicenseSet.size();
    }

    private boolean needUpdate(final License license){
        if (license.isAvailable()) return false;

        long time = System.currentTimeMillis();

        return time > license.getRentalEndTime();
    }
}
