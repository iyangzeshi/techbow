package javaOOD_system.java_OOD.problem5_design_an_elevator_system;//Project: techbow

//Package: javaOODSystem.javaOOD.problem5_design_an_elevator_system
//ClassName: User
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-20 星期五 16:41
public class User{
	public void generateRequset(int targetFloor) {
		RequestHandler.getInstance().addRequest(new Request(targetFloor));
	}
}

