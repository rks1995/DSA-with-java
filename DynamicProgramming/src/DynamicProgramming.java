import java.util.Scanner;

public class DynamicProgramming {

	public static int fibN(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int ans1 = fibN(n - 1);
		int ans2 = fibN(n - 2);
		int myAns = ans1 + ans2;
		return myAns;
	}

	public static int fibN2(int n, int dp[]) {
		if (n == 0 || n == 1) {
			return n;
		}

		int ans1;
		int ans2;
		if (dp[n - 1] == -1) {
			ans1 = fibN2(n - 1, dp);
			dp[n - 1] = ans1;
		} else {
			ans1 = dp[n - 1];
		}
		if (dp[n - 2] == -1) {
			ans2 = fibN2(n - 2, dp);
			dp[n - 2] = ans2;
		} else {
			ans2 = dp[n - 2];
		}

		return ans1 + ans2;
	}

	public static String coinTower(int n, int x, int y) {
		if (n == 0) {
			return "B";
		}
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[x] = 1;
		dp[y] = 1;
		for (int i = Math.max(x, y) + 1; i <= n; i++) {
			int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
			dp[i] = dp[i - 1] ^ 1;
			if (i - x >= 1) {
				a = dp[i - x] ^ 1;
			}
			if (i - y >= 1) {
				b = dp[i - y] ^ 1;
			}
			dp[i] = Math.max(dp[i], Math.max(a, b));
		}

		if (dp[n] != 0) {
			return "A";
		}
		return "B";
	}

	public static int minCost(int[][] cost, int i, int j, int[][] dp) {
		int m = cost.length;
		int n = cost[0].length;
		// special case
		if (i == m - 1 && j == n - 1) {
			return cost[i][j];
		}
		// base case
		if (i >= m || j >= n) {
			return Integer.MAX_VALUE;
		}

		int right;
		int dia;
		int down;

		if (dp[i][j + 1] == Integer.MIN_VALUE) {
			right = minCost(cost, i, j + 1, dp);
			dp[i][j + 1] = right;
		} else {
			right = dp[i][j + 1];
		}
		if (dp[i + 1][j + 1] == Integer.MIN_VALUE) {
			dia = minCost(cost, i + 1, j + 1, dp);
			dp[i + 1][j + 1] = dia;
		} else {
			dia = dp[i + 1][j + 1];
		}
		if (dp[i + 1][j] == Integer.MIN_VALUE) {
			down = minCost(cost, i + 1, j, dp);
			dp[i + 1][j] = down;
		} else {
			down = dp[i + 1][j];
		}

		int myCost = cost[i][j] + Math.min(right, Math.min(dia, down));
		return myCost;
	}

	public static int minCostIterative(int[][] cost) {
		int m = cost.length;
		int n = cost[0].length;
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[0][i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i <= m; i++) {
			dp[i][0] = Integer.MAX_VALUE;
		}
		dp[1][1] = cost[0][0];
		for (int i = 2; i <= n; i++) {
			dp[1][i] = cost[0][i - 1] + Math.min(dp[0][i - 1], Math.min(dp[0][i - 1], dp[1][i - 1]));
		}
		for (int i = 2; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = cost[i - 1][j - 1] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
			}
		}

		return dp[m][n];
	}

	public static int lcs(String s, String t, int i, int j) {
		if (i == s.length() || j == t.length()) {
			return 0;
		}
		if (s.charAt(i) == t.charAt(j)) {
			return 1 + lcs(s, t, i + 1, j + 1);
		} else {
			int ans1 = lcs(s, t, i + 1, j);
			int ans2 = lcs(s, t, i, j + 1);
			return Math.max(ans1, ans2);
		}
	}

	public static int lcsR(String s, String t, int i, int j, int[][] dp) {
		if (i == s.length() || j == t.length()) {
			return 0;
		}
		if (s.charAt(i) == t.charAt(j)) {
			dp[i][j] = 1 + lcsR(s, t, i + 1, j + 1, dp);
			return dp[i][j];
		} else {
			int ans1;
			int ans2;
			if (dp[i + 1][j] == -1) {
				ans1 = lcsR(s, t, i + 1, j, dp);
				dp[i + 1][j] = ans1;
			} else {
				ans1 = dp[i + 1][j];
			}
			if (dp[i][j + 1] == -1) {
				ans2 = lcsR(s, t, i, j + 1, dp);
				dp[i][j + 1] = ans2;
			} else {
				ans2 = dp[i][j + 1];
			}
			return Math.max(ans1, ans2);
		}
	}

	public static int lcsIterative(String s, String t) {
		int m = s.length();
		int n = t.length();
		if (m == 0 || n == 0) {
			return 0;
		}
		int dp[][] = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1]));
				}
			}
		}
		return dp[m][n];
	}

	public static int editDistance(String s, String t) {
		// base case
		if (s.length() == 0) {
			return t.length();
		}
		if (t.length() == 0) {
			return s.length();
		}

		if (s.charAt(0) == t.charAt(0)) {
			return editDistance(s.substring(1), t.substring(1));
		} else {
			int delete = editDistance(s.substring(1), t);
			int insert = editDistance(s, t.substring(1));
			int replace = editDistance(s.substring(1), t.substring(1));

			return 1 + Math.min(delete, Math.min(insert, replace));
		}

	}

	public static int editDistanceR(String s, String t, int[][] dp) {
		int m = s.length();
		int n = t.length();
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}

		if (s.charAt(0) == t.charAt(0)) {
			return editDistanceR(s.substring(1), t.substring(1), dp);
		}

		int delete;
		int insert;
		int replace;
		if (dp[m - 1][n] == -1) {
			delete = editDistanceR(s.substring(1), t, dp);
			dp[m - 1][n] = delete;
		} else {
			delete = dp[m - 1][n];
		}
		if (dp[m][n - 1] == -1) {
			insert = editDistanceR(s, t.substring(1), dp);
			dp[m][n - 1] = insert;
		} else {
			insert = dp[m][n - 1];
		}
		if (dp[m - 1][n - 1] == -1) {
			replace = editDistanceR(s.substring(1), t.substring(1), dp);
			dp[m - 1][n - 1] = replace;
		} else {
			replace = dp[m - 1][n - 1];
		}

		int myAns = 1 + Math.min(delete, Math.min(insert, replace));
		return myAns;
	}

	public static int editDistanceI(String s, String t) {
		int dp[][] = new int[s.length() + 1][t.length() + 1];
		int m = s.length();
		int n = t.length();
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					// if both char is same then reduce the size of both string by 1
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
				}
			}
		}
//		for(int i=0; i<dp.length; i++) {
//			for(int j=0; j<dp[0].length; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		return dp[m][n];

	}

	public static int knapsack(int[] w, int[] v, int W, int si) {

		if (W == 0 || si == v.length) {
			return 0;
		}

		if (w[si] > W) {
			return knapsack(w, v, W, si + 1);
		} else {
			int include = v[si] + knapsack(w, v, W - w[si], si + 1);
			int exclude = knapsack(w, v, W, si + 1);

			return Math.max(include, exclude);
		}

	}

	public static int knapsackDP(int[] w, int[] v, int W, int si, int[][] dp) {
		if (W == 0 || si == v.length) {
			return 0;
		}

		if (w[si] > W) {
			return knapsackDP(w, v, W, si + 1, dp);
		} else {
			int include;
			int exclude;
			if (dp[W - w[si]][si + 1] == -1) {
				include = v[si] + knapsackDP(w, v, W - w[si], si + 1, dp);
				dp[W - w[si]][si + 1] = include;
			} else {
				include = dp[W - w[si]][si + 1];
			}
			if (dp[W][si + 1] == -1) {
				exclude = knapsackDP(w, v, W, si + 1, dp);
				dp[W][si + 1] = exclude;
			} else {
				exclude = dp[W][si + 1];
			}

			return Math.max(include, exclude);
		}

	}

	public static int knapsackIterative(int[] wt, int[] v, int W) {
		int n = v.length;
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 0; i <= W; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= W; w++) {
				if (w < wt[i - 1]) {
					dp[i][w] = dp[i - 1][w];
				} else {
					dp[i][w] = Math.max(dp[i - 1][w], v[i - 1] + dp[i - 1][w - wt[i - 1]]);
				}
			}
		}
		return dp[n][W];

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
//		System.out.println(fibN(n));
		int dp[] = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			dp[i] = -1;
		}
		System.out.println(fibN2(n, dp));
//		
//		System.out.println(coinTower(6, 4, 2));

//		int cost[][] = {{1,5,11},{8,13,12}, {2,3,7}, {15,16,18}};
//		int dp[][] = new int[cost.length+1][cost[0].length+1];
//		for(int i=0; i<dp.length; i++) {
//			for(int j=0; j<dp[0].length; j++) {
//				dp[i][j] = Integer.MIN_VALUE;
//			}
//		}
//		System.out.println(minCost(cost, 0, 0, dp));
//		System.out.println(minCostIterative(cost));
//		String s = "abdgec";
//		String t = "bfdmgjc";
//		int dp[][] = new int[s.length()+1][t.length()+1];
//		for(int i=0; i<dp.length; i++) {
//			for(int j=0; j<dp[0].length; j++) {
//				dp[i][j] = -1;
//			}
//		}
//		System.out.println(lcs(s,t,0,0));
//		System.out.println(lcsR(s,t,0,0,dp));
//		System.out.println(lcsIterative(s, t));
//		System.out.println(editDistanceI(s,t));

//		int w[] = {1,2,3,8,7,4};
//		int v[] = {20,5,10,40,15,25};
//		int W = 10;
//		
//		int dp[][] = new int[W+1][v.length+1];
//		
//		for(int i=0; i<dp.length; i++) {
//			for(int j=0; j<dp[0].length; j++) {
//				dp[i][j] = -1;
//			}
//		}
//		
//		System.out.println(knapsackDP(w, v, W, 0, dp));
//		System.out.println(knapsackIterative(w, v, W));

	}

}
