package bq_resume.he_ma_sea_sood_system;

/**
 * The Enum for Food package size
 */
public enum FoodPackSize {

    SMALL("SMALL",1),

    MEDIUM("MEDIUM",2),

    LARGE("LARGE",4);

    //The String of the Enum
    private final String type;

    //The size for each type
    private final int size;

    FoodPackSize(final String type, final int size) {
        this.type = type;
        this.size = size;
    }

    public String toString(){
        return type;
    }

    public int getSize(){
        return size;
    }
}
