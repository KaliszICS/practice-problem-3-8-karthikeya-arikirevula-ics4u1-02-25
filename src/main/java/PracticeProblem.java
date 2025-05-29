public class PracticeProblem {

	public static int fib(int numero) {
		if (numero == 0) return 0;
		if (numero == 1) return 1;

		int[] memo = new int[numero + 1];
		for(int i = 0; i <= numero; i++) memo[i] = -1;

		return fibHelper(numero, memo);
	}

	private static int fibHelper(int n, int[] memo) {
		if (n == 0 || n == 1) return n;
		if (memo[n] != -1) return memo[n];

		memo[n] = fibHelper(n-1, memo) + fibHelper(n-2, memo);
		return memo[n];
	}

	public static int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0) return 0;
		if (cost.length == 1) {
			int[] memo = new int[2];
			for(int i=0; i<memo.length; i++) memo[i] = -1;
			return minCostHelper(0, cost, memo);
		}
		int[] memo = new int[cost.length + 1];
		for(int i=0; i<memo.length; i++) memo[i] = -1;
		return Math.min(minCostHelper(cost.length - 1, cost, memo), minCostHelper(cost.length - 2, cost, memo));
	}

	private static int minCostHelper(int i, int[] cost, int[] memo) {
		if (i == 0) return cost[0];
		if (i == 1) return cost[1];
		if (memo[i] != -1) return memo[i];
		memo[i] = cost[i] + Math.min(minCostHelper(i-1, cost, memo), minCostHelper(i-2, cost, memo));
		return memo[i];
	}
}