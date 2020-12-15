package bq_resume.he_ma_sea_sood_system;

/**
 * The service to update the order,notice Fridge and client
 */
public interface ISeaFoodService {

    /** The method to get thr order according to the orderId */
    Order getSeaFoodOrder(final String orderId);

    /** The method to update the order with the pass code generated*/
     boolean updateOrder(final Order order, String passCode);

    /** The method to generate the pass code for user to open the cell*/
     String generateCode(final String itemId);
     
     /** The method to get order information according to the userId */
     String getOrderInfo(String userId);

    /** The method to notice the client according to the client id */
     boolean noticeClient(final String orderId);

    /** The method to update the order's OrderStatus */
     boolean updateOrderStatus(final String orderId, final ShippingStatus status);

    /** The method find the best firdge for the order according to its final destination */
     IotFoodFridge getBestFridgeLocation(final String destinationAddress);

    /** The method to get the producer information according to the producerId*/
     String getProducerInfo(final String producerId);
}
