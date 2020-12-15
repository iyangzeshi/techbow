package javaOOD_system.java_OOD.problem1_poker;//Project: techbow

import java.util.Random;

//Package: javaOODSystem.javaOOD.poker
//ClassName: RandomSingleton
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-18 星期三 15:45
public class RandomSingleton {
	private static RandomSingleton instance;
	private static Random random;
	
	private RandomSingleton() {
		random = new Random();
		// randomInstance = new super();
	}
	
	public static RandomSingleton getInstance() {
		if(instance == null) {
			synchronized (RandomSingleton.class) {
				if (instance == null) { // thread safe purpose (保证线程安全)
					instance = new RandomSingleton();
				}
			}
		}
		return instance;
	}
	
	public int nextInt() {
		return random.nextInt();
	}
	
	public int nextInt(int n) {
		return random.nextInt(n);
	}
	
	public boolean nextBoolean() {
		return random.nextBoolean();
	}
	
	public static void main(String[] args) {
		RandomSingleton random1 = RandomSingleton.getInstance();
		RandomSingleton random2 = RandomSingleton.getInstance();
		System.out.println(random1.nextInt(5));
		System.out.println(random2.nextInt(5));
	}
}