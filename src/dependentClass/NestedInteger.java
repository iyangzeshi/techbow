package dependentClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Program: leetcode_practice
 * @ClassName: NestedInteger
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-07-09 17:24
 */
public class NestedInteger{
	private Integer value;
	private List<NestedInteger> list;

	// Constructor initializes an empty nested list.
	public NestedInteger() {
		this.list = new LinkedList<>();
	}
	// Constructor initializes a single integer.
	public NestedInteger(int value) {
		this.value = value;
	}
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger() {
		return this.value != null;
	}
	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return this.value;
	}
	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value){
		this.value = value;
	}

	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni) {
		// this NestedInteger currently holds a single integer
		// change it to NestedList and add its previous value
		if(this.isInteger()) {
			this.list = new LinkedList<>();
			this.list.add(this);
			this.value = null;
		}
		// this NestedInteger currently holds a NestedList
		// add the NestedInteger to the list
		else {
			this.list.add(ni);
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(this.isInteger()) {
			sb.append(this.value);
			return sb.toString();
		}
		else {
			sb.append("[");
			int size = this.list.size();
			for (int i = 0; i < size; i++) {
				sb.append(list.get(i).toString());
				if (i != size - 1) {
					sb.append(",");
				}
			}
			sb.append("]");
		}
		return sb.toString();
	}


	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return this.list;
	}

	// Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
	// Each element is either an integer, or a list -- whose elements may also be integers or other lists.
	public static int depthSum(List<NestedInteger> nestedList) {
		if(nestedList == null || nestedList.size() == 0) return 0;
		Queue<NestedInteger> queue = new LinkedList<>();
		int sum = 0;
		int level = 1;
		for(NestedInteger ni: nestedList){
			queue.offer(ni);
		}
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size-- > 0){
				NestedInteger cur = queue.poll();
				if(cur.isInteger()){
					sum += level*cur.getInteger();
				}
				else{
					for(NestedInteger ni: cur.getList())
						queue.offer(ni);
				}
			}
			level++;
		}
		return sum;
	}
	public static void main(String[] args) {
		// Test 1
		// Generating test case
		// [[1,1],2,[1,1]]
		List<NestedInteger> nestedList = new LinkedList<>();
		NestedInteger ni0 = new NestedInteger(1);
		NestedInteger ni1 = new NestedInteger(1);
		NestedInteger ni2 = new NestedInteger(2);
		NestedInteger ni3 = new NestedInteger(1);
		NestedInteger ni4 = new NestedInteger(1);
		NestedInteger ni5 = new NestedInteger();
		NestedInteger ni6 = new NestedInteger();

		ni5.add(ni0);ni5.add(ni1); // [1,1]
		ni6.add(ni3);ni6.add(ni4); // [1,1]
		nestedList.add(ni5); nestedList.add(ni2); nestedList.add(ni6); // [[1,1],2,[1,1]]

		// testing class def and depthSum method
		int output = NestedInteger.depthSum(nestedList);
		System.out.println("--- Test 1 ---");
		System.out.println("Testing depthSum(): " + "[[1,1], 2, [1,1]]");
		System.out.println("Output: " + output);
		System.out.println("Expected: " + 10);

		// testing toString
		System.out.println("Testing toString(): " + nestedList);

		System.out.println();
		// Test 2
		// Generating test case
		// [1,[4,[6]]]
		List<NestedInteger> nestedList_2 = new LinkedList<>();
		NestedInteger ni0_2 = new NestedInteger(1);
		NestedInteger ni1_2 = new NestedInteger(4);
		NestedInteger ni2_2 = new NestedInteger(6);
		NestedInteger ni3_2 = new NestedInteger();
		NestedInteger ni4_2 = new NestedInteger();
		ni3_2.add(ni2_2); // [6]
		ni4_2.add(ni1_2); ni4_2.add(ni3_2); // [4,[6]]
		nestedList_2.add(ni0_2); nestedList_2.add(ni4_2); // [1, [4, [6]]]
		// testing class def and depthSum method
		int output_2 = NestedInteger.depthSum(nestedList_2);
		System.out.println("--- Test 2 ---");
		System.out.println("Testing depthSum(): " + "[1, [4,[6]]]");
		System.out.println("Output: " + output_2);
		System.out.println("Expected: " + 27);

		// testing toString
		System.out.println("Testing toString(): " + nestedList_2);
	}
}
