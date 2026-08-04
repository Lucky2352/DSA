class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                return x * myPow(x, Integer.MAX_VALUE);
            }
            n = -n;
        }
        if (n % 2 == 0) {
            double half = myPow(x, n / 2);
            return half * half;
        } else {
            double half = myPow(x, n / 2);
            return x *half * half;
        }
    }
}