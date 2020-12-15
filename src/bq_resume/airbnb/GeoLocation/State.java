package bq_resume.airbnb.GeoLocation;

/**
 * Created by FLK on 2020-01-01.
 */
public enum State {
    CA("CA"),
    NY("NY");


    private final String name;

    State(final String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
