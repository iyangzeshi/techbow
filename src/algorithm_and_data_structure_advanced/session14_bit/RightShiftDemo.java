package algorithm_and_data_structure_advanced.session14_bit;

/**
 * @Program: techbow
 * @ClassName: RightShiftDemo
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-07-28 18:31
 */
public class RightShiftDemo {
	
	private static void print(int n) {
		
		String ret = "";
		
		for (int i = 0; i < 32; i++) {
			ret = (n & 1) + ret;
			
			n >>= 1;
		}
		
		System.out.println(ret);
	}
	
	public static void main(String[] args) {
		
		int n = Integer.MIN_VALUE;
		
		System.out.println(">> Demo");
		for (int i = 0; i < 32; i++) {
			print(n);
			
			n >>= 1;
		}
		
		System.out.println("\n>>> Demo");
		n = Integer.MIN_VALUE;
		for (int i = 0; i < 32; i++) {
			print(n);
			
			n >>>= 1;
		}
	}
}
