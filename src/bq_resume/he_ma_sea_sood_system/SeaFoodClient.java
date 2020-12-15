package bq_resume.he_ma_sea_sood_system;

import com.sun.istack.internal.NotNull;

/**
 * The class to represent the client of this system
 */
public class SeaFoodClient {

    /** The id for this client */
    private final String clientId;

    /** The id of the user */
    private String userId;

    /** The backend sea food service */
    private final ISeaFoodService seaFoodService;

    /**
     * Constructor
     *
     * @param   clientId           The id for this client
     * @param   seaFoodService     The backend sea food service
     */
    public SeaFoodClient(@NotNull String clientId, @NotNull ISeaFoodService seaFoodService){
        this.clientId = clientId;
        this.seaFoodService = seaFoodService;
    }

    public void setUserId(final String id){
        userId = id;
    }

    /**
     * The method to get the order information
     * @return String of the order information in Json format
     */
    public String checkOrderInfo(){
        if(userId == null) {
            return null;
        }

        return seaFoodService.getOrderInfo(userId);
    }

    public String getClientId(){
        return clientId;
    }

    public void onMessageReceived(@NotNull final String message){
        showMessage(message);
    }

    private void showMessage(final String message){
        System.out.print(message);
    }

}
