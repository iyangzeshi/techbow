package algorithm_and_data_structure_basic.session13_DP;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session13DP
//ClassName: FindLargestSquareSurroundedBy1
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-15 星期五 10:51

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

/*
找最大的正方形，可以空心
 */
// T(m, n) = O(m * n * min(m, n)), S(m,n) = O(m * n)
class FindLargestSquareSurroundedBy1 {
    
    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 0, 1, 1, 1, 1},
                        {1, 0, 1, 1, 0, 1},
                        {1, 1, 1, 0, 0, 1},
                        {0, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1, 0},
                        {0, 0, 1, 0, 0, 0}
                };
        System.out.println("The size of largest square sub-matrix is "
                + findLargestSquareSubMatrix(mat));
    }
    
    // Function to find the largest square sub-matrix which is surrounded by all 1's
    public static int findLargestSquareSubMatrix(int[][] matrix) {
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

        int maxLen = 0;
        
        // find the largest square surrounded by 1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int len = Math.min(right[i][j], down[i][j]);
                while (len > 0) {
                    boolean isSquare = down[i][j + len - 1] >= len && right[i + len - 1][j] >= len;
                    if (isSquare && maxLen < len) {
                        maxLen = len;
                    }
                    len--;
                }
            }
        }
        
        return maxLen;
    }
    
}
