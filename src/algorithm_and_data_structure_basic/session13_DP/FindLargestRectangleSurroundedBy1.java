package algorithm_and_data_structure_basic.session13_DP;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session13DP
//ClassName: FindLargestRectangle
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-15 星期五 15:24

/*
mat[6][6] = 1  0  1  1  1  1
            1  0  1  1  0  1
            1  1  1  0  0  1
            0  1  1  1  1  1
            1  1  1  0  1  0
            0  0  1  0  0  0

right[i][j] means how many consecutive 1 from (i, j) to left
right[6][6] =
            1  0  4  3  2  1
            1  0  2  1  0  1
            3  2  1  0  0  1
            0  5  4  3  2  1
            3  2  1  0  1  0
            0  0  1  0  0  0

down[i][j] means how many consecutive 1 from (i, j) to up
down[6][6] =
            3  0  6  1  1  4
            2  0  5  2  0  3
            1  3  4  0  0  2
            0  2  3  1  2  1
            1  1  2  0  1  0
            0  0  1  0  0  0
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
找最大的矩形，可以空心
 */
// T(m, n) = O(m * n * m * n), S(m,n) = O(m * n)
public class FindLargestRectangleSurroundedBy1 {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 0, 1, 1, 1, 1},
                        {1, 0, 1, 1, 0, 1},
                        {1, 1, 1, 0, 0, 1},
                        {0, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1, 0},
                        {0, 0, 1, 0, 0, 0}
                };
        int[] res = findLargestSquareSubMatrix(matrix);
        System.out.println("The area of largest rectangle sub-matrix is "
                + Arrays.toString(res));
    }
    
    // Function to find the largest square sub-matrix which is surrounded by all 1's
    public static int[] findLargestSquareSubMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] right = new int[rows][cols];
        int[][] down = new int[rows][cols];
        
        // get right and down by dp
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (i == rows - 1) {
                    down[i][j] = 1;
                } else {
                    down[i][j] = down[i + 1][j] + 1;
                }
    
                if (j == cols - 1) {
                    right[i][j] = 1;
                } else {
                    right[i][j] = right[i][j + 1] + 1;
                }
            }
        }
        
        int maxArea = 0;
        int[] offset = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[][] DIRECTIONS = {{-1, 0}, {0, -1}};
        // find the largest square surrounded by 1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int rowMax = down[i][j];
                int rowDelta = rowMax;
                int colMax = right[i][j];
                int colDelta = colMax;
                Set<Integer> visited = new HashSet<>();
                visited.add((rowMax - 1) * colMax + colMax - 1);
                PriorityQueue<Cell> maxHeap = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);
                while (down[i][j + colDelta - 1] < rowDelta || right[i + rowDelta - 1][j] < colDelta) {
                    for (int[] dir: DIRECTIONS) {
                        int r = rowDelta + dir[0];
                        int c = colDelta + dir[1];
                        if (!visited.contains((r - 1) * colMax + c - 1) && r >= 1 && c >= 1) {
                            visited.add((r - 1) * colMax + c - 1);
                            maxHeap.offer(new Cell(r, c));
                        }
                    }
                    Cell cell = maxHeap.poll();
                    rowDelta = cell.rowDelta;
                    colDelta = cell.colDelta;
                }
                int area = rowDelta * colDelta;
                if (area > maxArea) {
                    maxArea = area;
                    offset[0] = i;
                    offset[1] = j;
                    offset[2] = rowDelta;
                    offset[3] = colDelta;
                }
            }
        }
        
        return offset;
    }
    
    private static class Cell {
        
        int rowDelta;
        int colDelta;
        int val;
        
        public Cell(int rowDelta, int colDelta) {
            this.rowDelta = rowDelta;
            this.colDelta = colDelta;
            this.val = rowDelta * colDelta;
        }
        
    }
    
}
