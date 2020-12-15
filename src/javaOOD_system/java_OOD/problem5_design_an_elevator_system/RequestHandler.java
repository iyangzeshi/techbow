package javaOOD_system.java_OOD.problem5_design_an_elevator_system;//Project: techbow

import java.util.ArrayList;
import java.util.List;

//Package: javaOODSystem.javaOOD.problem5_design_an_elevator_system
//ClassName: RequestionHandler
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-20 星期五 16:41
public class RequestHandler {
	
	List<Request> requests;
	private static volatile RequestHandler instance = null;
	
	public static RequestHandler getInstance() {
		if (instance == null) {
			synchronized (RequestHandler.class) {
				if (instance == null) {
					instance = new RequestHandler();
				}
			}
			return instance;
		}
		return instance;
	}
	
	private RequestHandler() {
		requests = new ArrayList<>();
	}
	
	public void addRequest(Request req) {
		synchronized (req) {
			requests.add(req);
		}
	}
	
	private Request getNextRequest() {
		int currentFloor = Elevator.getInstance().getCurrentFloor();
		int shortestdistance = Integer.MAX_VALUE;
		Request next = null;
		
		for (Request req : requests) {
			if (Math.abs(req.getTargetFloor() - currentFloor) < shortestdistance) {
				next = req;
			}
		}
		return next;
	}
	
	public void processRequest() {
		while (true) {
			Request req = getNextRequest();
			if (req != null) {
				while (Elevator.getInstance().getStatus() != 0) {
				}
				Elevator.getInstance().moveToFloor(req.getTargetFloor());
				// req.remove(req);
			}
		}
		
	}
}


