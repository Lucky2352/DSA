class Solution {
    boolean[][] dp;
    boolean[][] visited;
    public boolean recursion(int i, int j, String s, String p) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (j == p.length()) {
            return false;
        }
        if (i == s.length()) {
            while (j < p.length()) {
                if (p.charAt(j) != '*') {
                    return false;
                }
                j++;
            }
            return true;
        }
        if (visited[i][j]) {
            return dp[i][j];
        }
        visited[i][j] = true;
        if (p.charAt(j) == '?') {
            return dp[i][j] = recursion(i + 1, j + 1, s, p);
        }
        if (p.charAt(j) == '*') {
            return dp[i][j] = recursion(i, j + 1, s, p) || recursion(i + 1, j, s, p);
        }
        if (p.charAt(j) == s.charAt(i)) {
            return dp[i][j] = recursion(i + 1, j + 1, s, p);
        }
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        dp = new boolean[s.length()][p.length()];
        visited = new boolean[s.length()][p.length()];
        return recursion(0, 0, s, p);
    }
}