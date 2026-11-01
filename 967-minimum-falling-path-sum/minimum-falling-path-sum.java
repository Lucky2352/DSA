class Solution {
    int dp[][];
    int recursion(int i,int j,int matrix[][],int n,int m,int[][]dp){
        if(i >= n || j >= m || j < 0)return Integer.MAX_VALUE;
        if(i == n - 1){
            return matrix[i][j];
        }
        if(dp[i][j] != Integer.MAX_VALUE)return dp[i][j];
        int down  = recursion(i + 1,j,matrix,n,m,dp);
        int right  = recursion(i + 1,j + 1,matrix,n,m,dp);
        int left  = recursion(i + 1,j - 1,matrix,n,m,dp);
        return dp[i][j] = matrix[i][j] + Math.min(down,Math.min(right,left));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int mini = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            mini = Math.min(recursion(0,i,matrix,n,m,dp),mini);
        }
        return mini;
    }
}