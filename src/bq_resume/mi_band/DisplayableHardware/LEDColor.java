package bq_resume.mi_band.DisplayableHardware;

/**
 * Created by FLK on 2019-12-31.
 */
public class LEDColor implements IdisplayableHardware{
    private final String equipId;

    public LEDColor(final String equipId) {
        this.equipId = equipId;
    }

    public String getEquipId(){
        return equipId;
    }

    public void displayNumber(final int num) {
        if (num > 80) {
            System.out.println("LED Display White");
        } else if (num > 60) {
            System.out.println("LED Display Green");
        } else if(num > 40) {
            System.out.println("LED Display Blue");
        } else if(num > 20) {
            System.out.println("LED Display Yellow");
        } else if(num > 0) {
            System.out.println("LED Display Red");
        } else {
            System.out.println("LED Display Off");
        }
    }

}
