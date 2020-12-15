package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

public class Session14and15Q21Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix1 = new int[][] {
			{2,	2,	7,	8,	8,	12},
            {4,	9,	9,	11},
            {8,	14,	17,	19,	21,	26},
            {9,	16,	19,	20,	21,	31,	35},
            {11,17,	22,	25,	26,	},
            {15,20,	26,	31,	36,	41,	45},
            {20,24,	26,	31}
		};
		
		int[][] matrix2 = new int[][] {
			{2,	2,	7,	8,	8,	12,	17},
			{11,17,	22,	25,	26,	34,	37},
            {8,	14,	17,	19,	21,	26,	26},
            {20,24,	26,	31,	39,	41,	46},
            {9,	16,	19,	20,	21,	31,	35},
            {15,20,	26,	31,	36,	41,	45},
            {3,	8,	9,	11,	14,	14,	22}
		};
		int[][] matrix3 = new int[][] {
			{1, 4},
			{2, 5},
			null
		};
		int[][] matrix4 = new int[][] {
			{1,2},
			{2,6}
		};
		int[][] matrix5 = new int[][] {
			{1,3},
			{2}
		};
		test(matrix5, 2);
		int k1 = 45;
		
		int k2 = 3;
		int k3 = 10;
		
		int t1 = 10;
		int t2 = 11;
		int t3 = 12;
		int t4 = 13;
		test(matrix3, k3);
		test(matrix1, t1);
		test(matrix1, t2);
		test(matrix1, t3);
		test(matrix1, t4);
		test(matrix1, k1);
		test(matrix2, k1);
		test(matrix3, k2);
		test(matrix3, k3);
		test(matrix4, 2);
		return;
	}

	private static void test(int[][] matrix, int k) {
		
		System.out.println("The k sorted array: ");
		for (int[] i : matrix) {
			System.out.print("[");
			if (i != null && i.length > 0) {
				for(int j: Arrays.copyOf(i, i.length - 1)) {
					System.out.print(j);
					System.out.print("\t");
				}
				System.out.print(i[i.length - 1]);
			}
			
			System.out.print("]");
			System.out.println();
		}
		int result = Session14and15Q21.kthSmallest(matrix, k);
		System.out.println(k + "th smallest element in matrix by method 1: " + result);
		System.out.println();
	}
}

