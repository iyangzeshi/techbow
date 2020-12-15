package bq_resume.movie_rent_system;


public class License {

    public static final long DEFAULT_TIME_STAMP = -1;

    private final String licenseId;

    private final String movieId;

    /**
     * Assume this license can only be rent for one user each time
     *
     * If we need to support
     */
    private String customerId;
    private long rentalStartTime;
    private long rentalEndTime;

    public License(final String licenseId, final String movieId){
        this.licenseId = licenseId;
        this.movieId = movieId;
        rentalStartTime = DEFAULT_TIME_STAMP;
        rentalEndTime = DEFAULT_TIME_STAMP;
    }

    public String getLicenseId(){
        return licenseId;
    }

    public String getMovieId(){
        return movieId;
    }

    public long getRentalStartTime(){
        return rentalStartTime;
    }

    public long getRentalEndTime(){
        return rentalEndTime;
    }

    public void rent(final String customerId, final long rentalStartTime, final long rentalEndTime){
        this.customerId = customerId;
        this.rentalStartTime = rentalStartTime;
        this.rentalEndTime = rentalEndTime;
    }

    public void release(){
        customerId = null;
        rentalStartTime = DEFAULT_TIME_STAMP;
        rentalEndTime = DEFAULT_TIME_STAMP;
    }

    public boolean isAvailable(){
        return customerId == null;
    }

}
