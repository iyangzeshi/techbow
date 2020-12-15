package bq_resume.elevator_design;

/**
 * Created by FLK on 2020-06-20.
 */
public enum Direction {

    UP("UP",1),
    STOP("STOP",0),
    DOWN("DOWN",-1);

    private final String directionName;
    private final int offset;

    Direction(final String name, final int offset) {
        this.directionName = name;
        this.offset = offset;
    }

    public String toString() {
        return directionName;
    }

    public int getOffset(){
        return offset;
    }
}
