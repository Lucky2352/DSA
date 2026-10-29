class Solution {
    int recursion(int i,int j,int n,int m,int[][] dp){
        if(i >= n || j >= m)return 0;
        if(i == n - 1 && j == m - 1){
            return 1;
        }
        if(dp[i][j] != -1)return dp[i][j];
        int left = recursion(i+1,j,n,m,dp);
        int right = recursion(i,j+1,n,m,dp);
        dp[i][j] = left + right;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++){
             Arrays.fill(dp[i],-1);
        }
        return recursion(0,0,m,n,dp);
    }
}