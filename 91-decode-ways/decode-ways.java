class Solution {
    public static int recursion(int i, String s,int[] dp) {
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if(dp[i] != 0)return dp[i];
        int count = recursion(i + 1, s,dp);
        if (i + 1 < s.length()) {
            if (s.charAt(i) == '1') {
                count += recursion(i + 2, s,dp);
            }
            if (s.charAt(i) == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6') {
                count += recursion(i + 2, s,dp);
            }
        }
        dp[i] = count;
        return count;
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        return recursion(0, s,dp);
    }
}