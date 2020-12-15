package bq_resume.mi_band;

import bq_resume.mi_band.DisplayableHardware.IdisplayableHardware;
import bq_resume.mi_band.DisplayableHardware.LEDArray;
import bq_resume.mi_band.DisplayableHardware.Screen;
import bq_resume.mi_band.DisplayableHardware.Speaker;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by FLK on 2020-06-20.
 */
public class MiBandV3 extends MiBand {
	
	private final Map<DisplayOption, IdisplayableHardware> hardwareMap;
	
	public MiBandV3(String id, final Screen screen) {
		super(id);
		hardwareMap = new HashMap<>();
		initHardWare();
	}
	
	private void initHardWare() {
		hardwareMap.put(DisplayOption.LED_ARRAY, new LEDArray("Techbow-LED"));
		hardwareMap.put(DisplayOption.SCREEN, new Screen("SC-123", "OLED"));
		hardwareMap.put(DisplayOption.VOICE, new Speaker("Speaker_123"));
	}
	
	public void updateNewHardware(final DisplayOption displayOption,
			final IdisplayableHardware hardware) {
		hardwareMap.put(displayOption, hardware);
	}

	//default display option is screen
	public void displayBatteryLife() {
		final IdisplayableHardware hardware = hardwareMap.get(DisplayOption.SCREEN);
		hardware.displayNumber(batteryLife);
	}
	
	@Override
	public void displayBatteryLife(final DisplayOption displayOption) throws NotSupportException {
		final IdisplayableHardware hardware = hardwareMap.get(displayOption);
		if (hardware == null) {
			// consider throw a self-defined exception
			throw new NotSupportException("MiBand V5 Not support this Option: " + displayOption);
		}
		hardware.displayNumber(getBatteryLife());
	}

	public void broadcast() {
		// only care about display option exception
		try{
			displayBatteryLife(DisplayOption.SCREEN);
		} catch (NotSupportException e){
			e.printStackTrace();
			System.out.println("we chose a wrong display option in MiBandV5");
		}
	}
}
