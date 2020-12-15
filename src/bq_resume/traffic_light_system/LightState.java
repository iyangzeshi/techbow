package bq_resume.traffic_light_system;

import com.sun.istack.internal.NotNull;

public enum LightState {
	GREEN("Green", 0),
	YELLOW("Yellow", 1),
	RED("Red", 2);
	
	private final String state;
	private final int stateCode;
	
	LightState(@NotNull final String state, @NotNull final int stateCode) {
		this.state = state;
		this.stateCode = stateCode;
	}
	
	public String getState() {
		return state;
	}
	
	public int getStateCode() {
		return stateCode;
	}
}
