package bq_resume.chess;
//Project: techbow
//Package: bq_resume.chess
//ClassName: Noder
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-23 星期一 20:14

import java.util.List;

/**
 *
 */
public abstract class Node {
	
	private int[] currentLocation;
	/**
	 * Option1: input: int[] 2. return type boolean
	 *
	 * input: target/ destination
	 * return boolean whether we can move
	 *
	 * Option2: input: 2. return type
	 */
	
	abstract boolean move(int[] destination);
	
	abstract boolean move(int x, int y);
	
	/**all reachable destinations */
	abstract List<int[]> canMove();
}
