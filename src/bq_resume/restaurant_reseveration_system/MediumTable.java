package bq_resume.restaurant_reseveration_system;

/**
 * Created by FLK on 2019-02-16.
 * The class that represent the medium table
 */
public class MediumTable extends BaseTable {
    private static final int capacity = TableType.MEDIUM.getCapacity();

    public MediumTable(final String id){
        super(id, TableType.MEDIUM);
    }
    
    public static int getCapacity() {
        return capacity;
    }
}