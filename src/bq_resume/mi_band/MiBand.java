package bq_resume.mi_band;

/**
 * Created by FLK on 2019-12-31.
 */
public abstract class MiBand {
    private final String id;

    //current percentage of remaining battery, range from 0 - 100%
    protected int batteryLife;

    public MiBand(final String id) {
        this.id = id;
    }

    public void setBatteryLife(final int percentage) {
        batteryLife = percentage;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public abstract void displayBatteryLife(final DisplayOption displayOption) throws Exception;
}
