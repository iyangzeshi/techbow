package algorithm_and_data_structure_basic.session14and15;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode130 {
	
	// solution 2: BFS
	int[][] directions = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	
	public void solve(char[][] board) {
		// corner case
		if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
			return;
		}
		
		int rows = board.length;
		int cols = board[0].length;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// do BFS for the first and last row
		for (int j = 0; j < cols; j++) {
			if (board[0][j] == 'O') {
				board[0][j] = 'Y';
				queue.offer(j);
				doBFSflipY(board, queue);
			}
			if (board[rows - 1][j] == 'O') {
				board[rows - 1][j] = 'Y';
				queue.offer((rows - 1) * cols + j);
				doBFSflipY(board, queue);
			}
		}
		
		// do BFS for the first and last col
		for (int i = 1; i < rows - 1; i++) {
			if (board[i][0] == 'O') {
				board[i][0] = 'Y';
				queue.offer(i * cols);
				doBFSflipY(board, queue);
			}
			if (board[i][cols - 1] == 'O') {
				board[i][cols - 1] = 'Y';
				queue.offer(i * cols + cols - 1);
				doBFSflipY(board, queue);
			}
		}
		
		// traverse the whole board, change 0 into X, and Y into 0
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				}
			}
		}
		
	}
	
	// queue is used to place the elements already changed to Y
	private void doBFSflipY(char[][] board, Queue<Integer> queue) {
		
		int rows = board.length;
		int cols = board[0].length;
		
		while (!queue.isEmpty()) {
			int index = queue.poll();
			int row = index / cols;
			int col = index % cols;
			for (int[] direction : directions) {
				int r = row + direction[0];
				int c = col + direction[1];
				if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
						|| board[r][c] != 'O') {
					continue;
				}
				board[r][c] = 'Y';
				queue.offer(r * cols + c);
			}
		}
	}
}
