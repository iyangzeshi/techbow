package bq_resume.mi_band;

import bq_resume.mi_band.DisplayableHardware.LEDColor;

/**
 * Created by FLK on 2020-06-20.
 */
public class MiBandV1 extends MiBand {

    private final LEDColor ledColor;

    public MiBandV1(String id) {
        super(id);
        ledColor = new LEDColor("123");
    }
    
    @Override
    public void displayBatteryLife(DisplayOption displayOption) {
    
    }
    
    public void displayBatteryLife() {
        ledColor.displayNumber(batteryLife);
    }
}
