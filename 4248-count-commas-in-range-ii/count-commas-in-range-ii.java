class Solution {
    public long countCommas(long n) {

        if (n < 1000) {
            return 0;
        }

        else if (n < 1000000) {
            return n - 999;
        }

        else if (n < 1000000000) {
            long ans = 999000L;
            ans += (n - 1000000L + 1) * 2;
            return ans;
        }

        else if (n < 1000000000000L) {
            long ans = 999000L;
            ans += 999000000L * 2;
            ans += (n - 1000000000L + 1) * 3;
            return ans;
        }

        else if (n < 1000000000000000L) {
            long ans = 999000L;
            ans += 999000000L * 2;
            ans += 999000000000L * 3;
            ans += (n - 1000000000000L + 1) * 4;
            return ans;
        }

        else {
            long ans = 999000L;
            ans += 999000000L * 2;
            ans += 999000000000L * 3;
            ans += 999000000000000L * 4;
            ans += (n - 1000000000000000L + 1) * 5;
            return ans;
        }
    }
}