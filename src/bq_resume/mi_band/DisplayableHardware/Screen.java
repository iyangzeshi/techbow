package bq_resume.mi_band.DisplayableHardware;

/**
 * Created by FLK on 2020-06-20.
 */
public class Screen implements IdisplayableHardware{
    private final String equipId;

    private final String typeId;

    public Screen(final String equipId, final String typeId) {
        this.equipId = equipId;
        this.typeId = typeId;
    }

    public String getEquipId(){
        return equipId;
    }

    public String getTypeId(){
        return typeId;
    }

    @Override
    public void displayNumber(final int num) {
        //Do something with the number
        System.out.println(num);
    }
}
