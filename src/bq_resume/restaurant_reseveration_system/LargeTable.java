package bq_resume.restaurant_reseveration_system;

/**
 * Created by FLK on 2019-02-16.
 * The class that represent the large table
 */
public class LargeTable extends BaseTable {
    
    private static final int capacity = TableType.LARGE.getCapacity();
    
    
    public LargeTable(final String id){
        super(id, TableType.LARGE);
    }
    
    public static int getCapacity() {
        return capacity;
    }
}