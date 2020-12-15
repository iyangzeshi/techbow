package bq_resume.he_ma_sea_sood_system;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * The abstract class that represent the type of SeaFood Item
 */
public abstract class SeaFoodItem {
    
    /** The name of the food*/
    private final String foodName;
    
    /** The id for this product*/
    private final String itemId;
    
    /** The PackageSize of this food */
    private final FoodPackSize packSize;
    
    /** The produced time */
    private final long producedTime;
    
    /** The expired time*/
    private long expiredTime;
    
    //这个只是临时措施，不是long term措施，最终还是要更新到field里面
    /** The field to put extra information*/
    private final Map<String,Object> extraInfo;
    
    /*
     * Constructor
     *
     * @param   foodName        The name of the food
     * @param   itemId          The id for this product
     * @param   packSize        The PackageSize of this food
     * @param   producedTime    The produced time for this food
     */
    public SeaFoodItem(@NotNull final String foodName, @NotNull final String itemId,
                       @NotNull final FoodPackSize packSize, final long producedTime) {
        this.foodName = foodName;
        this.itemId = itemId;
        this.packSize = packSize;
        this.producedTime = producedTime;
        extraInfo = new HashMap<String,Object>();
    }

    /*
     * Constructor
     *
     * @param   foodName        The name of the food
     * @param   itemId          The id for this product
     * @param   packSize        The PackageSize of this food
     * @param   producedTime    The produced time for this food
     * @param   extraInfo       The field to put extra information
     */
    public SeaFoodItem(@NotNull final String foodName, @NotNull final String itemId,
                       @NotNull final FoodPackSize packSize, final long producedTime,
                       @NotNull final Map<String,Object> extraInfo) {
        this.foodName = foodName;
        this.itemId = itemId;
        this.packSize = packSize;
        this.producedTime = producedTime;
        this.extraInfo = extraInfo;
    }

    public String getFoodName(){
        return foodName;
    }

    public String getItemId(){
        return itemId;
    }

    public FoodPackSize getPackSize(){
        return packSize;
    }

    public int getSize(){
        return packSize.getSize();
    }

    public long getProducedTime(){
        return producedTime;
    }

    public long getExpiredTime(){
        return expiredTime;
    }

    public Map<String,Object> getExtraInfo(){
        return extraInfo;
    }

    public boolean setExpiredTime(final long expiredTime){
        if(expiredTime < System.currentTimeMillis() || expiredTime < producedTime) {
            return false;
        }

        this.expiredTime = expiredTime;

        return true;
    }

    public abstract int getFreshLevelIndex();
}
