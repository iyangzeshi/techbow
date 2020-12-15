package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
一个二维matrix，每一行都是sorted，可能有duplicates
让你找这个所有数字里面的第k大的数字
 */
public class Q22_1FindKthSmallestElementsInKSortedArray {
	
	public static void main(String[] args) {
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
		int result = new Q22_1FindKthSmallestElementsInKSortedArray().kthSmallest(matrix, k);
		System.out.println(k + "th smallest element in matrix by method 1: " + result);
		System.out.println();
	}
	
	// case 1: int[][]不是一个长方形，每一行的长度不一定一样
	// 每次找出剩下的需要找的数量的前 / rows个
	public int kthSmallest(int[][] matrix, int k) {
		// corner case
		if (matrix == null || matrix.length == 0) {
			return Integer.MAX_VALUE;
		}
		if (matrix.length == 1 && k <= matrix[0].length) {
			return matrix[0][k - 1];
		}
		int numElements = 0;
		int tempMax = Integer.MIN_VALUE;
		for (int[] row : matrix) {
			if (row != null && row.length > 0) {
				tempMax = Math.max(row[row.length - 1], tempMax);
				numElements += row.length;
			}
		}
		if (k > numElements) {
			return tempMax;
		}

		// general case
		int rows = matrix.length; // number of row arrays

		/**
		 * leftRows 用来放需要寻找的行, 考虑到edge case， 有些行走完可能还没用完(k - rank) / leftRowsNum个元素
		 */
		Integer[] leftRows = new Integer[rows];
		int[] colIndex = new int[matrix.length]; // 每一行用到那一列了
		for (int i = 0; i < rows; i++) {
			if (matrix[i] == null || matrix[i].length == 0) {
				leftRows[i] = null;
			} else {
				leftRows[i] = i;
			}
			colIndex[i] = -1;
		}
		int leftRowsNum = rows;

		int rank = 0; // 当前的element是第rank小
		int leftRank = 0; // 当前要往后从小到大在按顺序找第leftRank小个

		while ((k - rank) / leftRowsNum > 1) {
			leftRank = (k - rank) / rows;
			int min = Integer.MAX_VALUE;
			int prevMin = Integer.MAX_VALUE - 1; // temporary to store previous min
			int minRow = 0; // the row index of the smallest elements among the candidates
			int minCol = 0; // the col index of the smallest elements among the candidates
			for (Integer i : leftRows) {
				if (i == null) {
					continue;
				} else {
					// j表示要比较的元素的纵坐标，最大只能取到cols - 1
					int j = colIndex[i] + (k - rank) / leftRowsNum >= matrix[i].length
							? matrix[i].length - 1
							: colIndex[i] + (k - rank) / leftRowsNum;
					min = Math.min(min, matrix[i][j]);
					// 遍历每一行的第接下来第leftRank歌的时候，看min有没有变，变的话，把横坐标存下来
					if (prevMin != min) {
						minRow = i;
						minCol = j;
					}
					prevMin = min;
				}
			}
			if (minCol == matrix[minRow].length - 1) {
				leftRows[minRow] = null;
				leftRowsNum--;
			}
			leftRank = minCol - colIndex[minRow];
			colIndex[minRow] += leftRank;
			rank += leftRank;
			// edge case
			if (rank == k) { // 如果rank已经取到了k，直接return 这个值
				return matrix[minRow][minCol];
			}
		}

		// 每次只能往后面找一个的时候，改用BFS minHeap做
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(rows);
		for (Integer i : leftRows) {
			if (i == null) {
				continue;
			}
			minHeap.add(new Cell(i, colIndex[i] + 1, matrix[i][colIndex[i] + 1]));
		}
		int row;
		int col;
		Cell temp;
		for (int i = rank + 1; i < k; i++) {
			temp = minHeap.poll();
			row = temp.row;
			col = temp.col;
			// 往右加一个数字
			if (col < matrix[row].length - 1) {
				minHeap.offer(new Cell(row, col + 1, matrix[row][col + 1]));
			}
		}
		temp = minHeap.poll();
		row = temp.row;
		col = temp.col;
		return matrix[row][col];
	}
	
	static class Cell implements Comparable<Cell> {
		int row;
		int col;
		int val;
	
		public Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	
		@Override
		public int compareTo(Cell o) {
			return this.val - o.val;
		}
	}
}