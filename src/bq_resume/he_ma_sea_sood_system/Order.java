package bq_resume.he_ma_sea_sood_system;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The data contract with backend to save the order information
 */
public class Order {

    /** The id of the order */
    private final String orderId;

    /** The id of the user who made this order */
    private final String userId;

    /** The id of the producer who ship this order */
    private final String producerId;

    /** The shipping address of this order */
    private final String shipAddress;

    /** The list of the items in this order */
    private final List<SeaFoodItem> seaFoodItems;

    /** The list of the items delivered item in this order */
    private final List<SeaFoodItem> deliveredItems;

    /** The shipping status of this order */
    private ShippingStatus shippingStatus;

    /** The ship time */
    private long shipTime;

    /** The estimate arrive time */
    private long arriveTime;

    /** The Fridge it should goes to */
    private IotFoodFridge destinationFridge;

    /** The address of the destination */
    private String destinationAddress;

    /** The field to put extra information */
    private final Map<String,Object> extraInfo;

    /**
     * Constructor
     *
     * @param   orderId           The id of the order
     * @param   userId            The id of the user who made this order
     * @param   producerId        The id of the producer who ship this order
     * @param   shipAddress       The shipping address of this order
     */
    public Order(@NotNull final String orderId, @NotNull final String userId,
                 @NotNull final String producerId, @NotNull final String shipAddress){

        this.orderId = orderId;
        this.userId = userId;
        this.producerId = producerId;
        this.shipAddress = shipAddress;

        seaFoodItems = new ArrayList<SeaFoodItem>();
        deliveredItems = new ArrayList<SeaFoodItem>();
        extraInfo = new HashMap<String,Object>();
        shippingStatus = ShippingStatus.CATCHED;
    }

    public String getOrderId(){
        return orderId;
    }

    public String getUserId(){
        return userId;
    }

    public String getProducerId(){
        return producerId;
    }

    public String getShipAddress(){
        return shipAddress;
    }

    public List<SeaFoodItem> getSeaFoodItems(){
        return seaFoodItems;
    }

    public List<SeaFoodItem> getDeliveredItems(){
        return deliveredItems;
    }

    public ShippingStatus getShippingStatus(){
        return shippingStatus;
    }

    public long getShipTime(){
        return shipTime;
    }

    public long getArriveTime(){
        return arriveTime;
    }

    public IotFoodFridge getDestinationFridge(){
        return destinationFridge;
    }

    public String getDestinationAddress(){
        return destinationAddress;
    }

    public Map<String,Object> getExtraInfo(){
        return extraInfo;
    }

    public boolean setShipTime(final long time){
        if(time < System.currentTimeMillis()) {
            return false;
        }

        shipTime = time;
        return true;
    }

    public boolean setArriveTime(final long time){
        if(time < System.currentTimeMillis() || time < shipTime) {
            return false;
        }

        arriveTime = time;
        return true;
    }

    public void setDestinationFridge(@NotNull final IotFoodFridge iotFoodFridge){
        destinationFridge = iotFoodFridge;
    }

    public void setDestinationAddress(@NotNull final String address){
        destinationAddress = address;
    }

    public void setShippingStatus(@NotNull final ShippingStatus status){
        shippingStatus = status;
    }

}
