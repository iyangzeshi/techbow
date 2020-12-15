package algorithm_and_data_structure_basic.session14and15;

import java.util.PriorityQueue;

public class Session14and15Q21 {

	// case 1: int[][]不是一个长方形，每一行的长度不一定一样
	// 每次找出剩下的需要找的数量的前 / rows个
	public static int kthSmallest(int[][] matrix, int k) {
		// corner case
		if (matrix == null || matrix.length == 0) {
			return Integer.MAX_VALUE;
		}
		if (matrix.length == 1 && k <= matrix[0].length) {
			return matrix[0][k - 1];
		}
		int numElements = 0;
		int tempMax = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i] != null && matrix[i].length > 0) {
				tempMax = Math.max(matrix[i][matrix[i].length - 1], tempMax);
				numElements += matrix[i].length;
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
		PriorityQueue<Cell21> minHeap = new PriorityQueue<>(rows);
		for (Integer i : leftRows) {
			if (i == null) {
				continue;
			}
			minHeap.add(new Cell21(i, colIndex[i] + 1, matrix[i][colIndex[i] + 1]));
		}
		int row;
		int col;
		Cell21 temp;
		for (int i = rank + 1; i < k; i++) {
			temp = minHeap.poll();
			row = temp.row;
			col = temp.col;
			// 往右加一个数字
			if (col < matrix[row].length - 1) {
				minHeap.offer(new Cell21(row, col + 1, matrix[row][col + 1]));
			}
		}
		temp = minHeap.poll();
		row = temp.row;
		col = temp.col;
		return matrix[row][col];
	}
}


class Cell21 implements Comparable<Cell21> {
	int row;
	int col;
	int val;

	public Cell21(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}

	@Override
	public boolean equals(Object object) {
		// corner case
		if (this == null || object == null || !(object instanceof Cell21)) {
			return false;
		}
		Cell21 obj = (Cell21) object;
		if (this == obj || (this.row == obj.row && this.col == obj.col)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Cell21 o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
