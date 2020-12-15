package bq_resume.snake_game;

/**
 * Created by FLK on 4/19/18.
 */
//List out all possible directions
public enum Direction {

    /*
    *      !->[0,0]
    *      e e e e e
    *      e e e e e
    *      e e e e e
    *      e e e e e
    *
    * */

    UP("UP", new int[]{-1, 0}),
    DOWN("DOWN", new int[]{1, 0}),
    RIGHT("RIGHT", new int[]{0, 1}),
    LEFT("LEFT", new int[]{0, -1});

    final private String direction;
    final private int[] value;

    Direction(final String direction, final int[] value){
        this.direction = direction;
        this.value = value;
    }

    public String toString(){
        return direction;
    }

    public int[] getValue(){
        return value;
    }

}
