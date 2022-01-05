package backtracking;

public class Backtracking {

	public static boolean ratInMaze(int[][] maze) {
		int n = maze.length;
		int visited[][] = new int[n][n];
		return solveMaze(maze, n, 0, 0, visited);
	}
	
	public static boolean solveMaze(int[][] maze, int n, int i, int j, int[][] visited) {
		if(i == n-1 && j==n-1) {
			visited[i][j] = 1;
			return true;
		}
		if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || visited[i][j] == 1) {
			return false;
		}
		
		visited[i][j] = 1;
		boolean top = solveMaze(maze, n, i-1, j, visited);
		boolean right = solveMaze(maze, n, i, j+1, visited);
		boolean down = solveMaze(maze, n, i+1, j, visited);
		boolean left = solveMaze(maze, n, i, j-1, visited);
		
		if(top || right || down || left)
			return true;
		return false;
		
	}
	
	public static void printAllPathsOfRatInMaze(int[][] maze) {
		int n = maze.length;
		int visited[][] = new int[n][n];
		int paths[][] = new int[n][n];
		printAllPathsHelper(maze, visited, 0, 0, n, paths);
	}
	
	public static void printAllPathsHelper(int[][] maze, int[][]visited, int i, int j, int n,int[][]paths) {
		
		if(i == n-1 && j==n-1) {
			visited[i][j] = 1;
			paths[i][j] = 1;
			for(int p=0; p<paths.length; p++) {
				for(int q=0; q<paths[p].length; q++) {
					System.out.print(paths[p][q]);
				}
			}
			System.out.println();
			return;
		}

		if(i<0 || j<0 || i>=n || j>=n || maze[i][j] == 0 || visited[i][j] == 1) {
			return;
		}
		
		visited[i][j] = 1;
		paths[i][j] = 1;
		printAllPathsHelper(maze, visited, i-1, j, n, paths);
		printAllPathsHelper(maze, visited, i, j+1, n, paths);
		printAllPathsHelper(maze, visited, i+1, j, n, paths);
		printAllPathsHelper(maze, visited, i, j-1, n, paths);
		visited[i][j] = 0;
		paths[i][j] = 0;
	}
	
	public static void placeNQueens(int n) {
		int[][] board = new int[n][n];
		placeQueens(board,n, 0);
	}
	
	private static void placeQueens(int[][] board,int n, int row) {
		if(row == n) {
			//valid configuration
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		//check for all columns
		for(int c=0; c<n; c++) {
			if(isSafe(board, row, c)) {
				board[row][c] = 1;
				placeQueens(board, n, row+1);
				board[row][c] = 0;
			}
		}
		
	}

	private static boolean isSafe(int[][] board, int r, int c) {
		int n = board.length;
		int count = 0;
		boolean isSafe = true;
		//up
		for(int i=r-1; i>=0; i--) {
			if(board[i][c] == 1) {
				isSafe = false;
			}
		}
		//leftUpperDiagonal
		for(int i = r-1; i>=0; i--) {
			count += 1;
			if(c-count >= 0 && board[i][c-count] == 1) {
				isSafe = false;
			}
		}
		count = 0;
		//rightUpperDiagonal
		for(int i = r-1; i >=0 ; i--) {
			count += 1;
			if(c+count < n && board[i][c+count] == 1) {
				isSafe = false;
			}
		}
		
		return isSafe;
		
	}

	public static void main(String[] args) {
//		int maze[][] = {{1,1,0},{1,1,0},{1,1,1}};
//		boolean hasPath = ratInMaze(maze);
//		System.out.println(hasPath);
//		printAllPathsOfRatInMaze(maze);
		placeNQueens(4);

	}

}
