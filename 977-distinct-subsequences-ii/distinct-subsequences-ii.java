class Solution {
    int MOD = 1000000007;
    public int distinctSubseqII(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq, -1);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1;i <= s.length();i++) {
            int ch = s.charAt(i - 1) - 'a';
            dp[i] = (2 * dp[i - 1]) % MOD;
            if (freq[ch] != -1) {
                dp[i] = (dp[i] - dp[freq[ch] - 1] + MOD) % MOD;
            }
            freq[ch] = i;
        }
        return (dp[s.length()] - 1 + MOD) % MOD;
    }
}