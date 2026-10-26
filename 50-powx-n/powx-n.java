class Solution {
    public static double recursion(double num, long pow) {
        if (pow == 0) return 1;
        if (pow == 1) return num;
        if (pow % 2 == 0) {
            return recursion(num * num, pow / 2);
        } else {
            return num * recursion(num, pow - 1);
        }
    }
    public double myPow(double x, int n) {
        long pow = n;
        if (pow < 0) {
            pow = -pow;
            return 1 / recursion(x, pow);
        }
        return recursion(x, pow);
    }
}