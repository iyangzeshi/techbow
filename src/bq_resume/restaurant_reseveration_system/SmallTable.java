package bq_resume.restaurant_reseveration_system;

/**
 * Created by FLK on 2019-02-16.
 */
public class SmallTable extends BaseTable {

    private static final int capacity = TableType.SMALL.getCapacity();
    
    public SmallTable(final String id){
        super(id, TableType.SMALL);
    }
    
    public static int getCapacity() {
        return 0;
    }
}