class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int prev2 = 1;
        int prev1 = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current += prev1;
            }
            int num = (s.charAt(i) - '0') * 10+ (s.charAt(i + 1) - '0');
            if (num >= 10 && num <= 26) {
                current += prev2;
            }
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}