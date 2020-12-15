package bq_resume.airbnb;

import java.util.Date;

/**
 * Created by FLK on 2020-01-01.
 */
public class Reservation {
    final String reservationId;
    final String userId;
    final Date[] reservationTime;

    public Reservation(final String reservationId, final String userId, final Date[] reservationTime){
        this.reservationId = reservationId;
        this.userId = userId;
        this.reservationTime = reservationTime;
    }

    public String getReservationId(){
        return reservationId;
    }

    public String getUserId(){
        return userId;
    }

    public Date[] getReservationTime(){
        return reservationTime;
    }
}
