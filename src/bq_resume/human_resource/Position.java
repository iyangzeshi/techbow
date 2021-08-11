package bq_resume.human_resource;

/**
 * Created by FLK on 2019-12-21.
 */
public enum Position {
    CEO("CEO",3),
    TEACHER("TEACHER",2),
    STUDENT("STUDENT",1);

    final private String type;
    final private int level;

    //Private Constructor
    Position(final String type, final int level) {
        this.type = type;
        this.level = level;
    }

    public String getType(){
        return type;
    }

    public int getLevel(){
        return level;
    }

}