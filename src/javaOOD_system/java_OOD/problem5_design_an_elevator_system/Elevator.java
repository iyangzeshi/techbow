package javaOOD_system.java_OOD.problem5_design_an_elevator_system;//Project: techbow

//Package: javaOODSystem.javaOOD.problem5_design_an_elevator_system
//ClassName: Elevator
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-20 星期五 16:33
public class Elevator {
	
	private int currentFloor;
	private int targetFloor;
	private int status;
	private static volatile Elevator instance = null;
	
	private Elevator() {
		this.currentFloor = 0;
		this.targetFloor = 0;
		this.status = 0;
	}
	
	public static Elevator getInstance() {
		if (instance == null) {
			synchronized (Elevator.class) {
				if (instance == null) {
					instance = new Elevator();
				}
			}
		}
		
		return instance;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void moveToFloor(int targetFloor) {
		while (currentFloor < targetFloor) {
			moveUp();
		}
		while (currentFloor > targetFloor) {
			moveDown();
		}
		
		status = 0;
	}
	
	private void moveUp() {
		status = 1;
		currentFloor += 1;
	}
	
	private void moveDown() {
		status = -1;
		currentFloor -= 1;
	}
}


