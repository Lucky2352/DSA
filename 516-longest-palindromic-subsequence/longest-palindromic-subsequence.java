class Solution {
    int maxi = 0;
    public void recursion(int i, int j, String s, int count, int[][] dp) {
        if (i > j) {
            maxi = Math.max(count, maxi);
            return;
        }
        if (i == j) {
            maxi = Math.max(maxi, count + 1);
            return;
        }
        if (dp[i][j] != -1 && dp[i][j] >= count) {
            return;
        }
        dp[i][j] = count;
        if (s.charAt(i) == s.charAt(j)) {
            recursion(i + 1, j - 1, s, count + 2, dp);
        }
        recursion(i + 1, j, s, count, dp);
        recursion(i, j - 1, s, count, dp);
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        recursion(0, n - 1, s, 0, dp);
        return maxi;
    }
}