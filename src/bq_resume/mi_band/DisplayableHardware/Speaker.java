package bq_resume.mi_band.DisplayableHardware;

/**
 * Created by FLK on 2020-06-20.
 */
public class Speaker implements IdisplayableHardware {
    private final String equipId;

    public Speaker(final String equipId) {
        this.equipId = equipId;
    }

    public String getEquipId(){
        return equipId;
    }

    @Override
    public void displayNumber(final int batteryLife) {
        readNumber(batteryLife);
    }

    private void readNumber(final int num){
        //Do something with the number
        System.out.println(num);
    }

    private void readString(final String str){
        // Do something with the String
        System.out.println(str);
    }
}
