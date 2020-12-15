package bq_resume.he_ma_sea_sood_system;

import com.sun.istack.internal.NotNull;

/**
 * The class of the very basic unit in Fridge to save the food
 */
public class Cell {

    /** The id for the cell in fridge */
    private final String cellId;

    /** The size of package that this cell can hold */
    private final FoodPackSize foodPackSize;

    /** The item that the cell currently hold */
    private SeaFoodItem seaFoodItem;

    /**
     * Constructor
     *
     * @param   cellId           The id for the cell in fridge
     * @param   foodPackSize     The size of package that this cell can hold
     */
    public Cell(@NotNull String cellId, @NotNull FoodPackSize foodPackSize){
        this.cellId = cellId;
        this.foodPackSize = foodPackSize;
    }

    public SeaFoodItem getItem() {
        return seaFoodItem;
    }

    public boolean isEmpty() {
        return seaFoodItem == null;
    }

    public String getCellId(){
        return cellId;
    }

    public FoodPackSize getPackgeSize() {
        return foodPackSize;
    }

    public int getSize(){
        return foodPackSize.getSize();
    }

    public void setItem(SeaFoodItem item) {
        seaFoodItem = item;
    }

    public void clear(){
        seaFoodItem = null;
    }
}
