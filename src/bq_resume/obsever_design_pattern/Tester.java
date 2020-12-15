package bq_resume.obsever_design_pattern;
//Project: techbow
//Package: bq_resume.ObseverDesignPattern
//ClassName: Tester
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-21 星期六 20:43

/**
 *
 */
public class Tester {
	
	public static void main(String[] args) {
		StateChangeObserverable stateChangeObserverable = new StateChangeObserverable(3);
		IStateWatcherA stateWatcherA = new IStateWatcherA();
		IStateWatcherB stateWatcherB = new IStateWatcherB();
		
		stateChangeObserverable.registerListeners(stateWatcherA);
		stateChangeObserverable.registerListeners(stateWatcherB);
		
		stateChangeObserverable.setState(5);
	}
}
