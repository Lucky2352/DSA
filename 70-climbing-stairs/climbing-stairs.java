class Solution {
    public int climbStairs(int n) {
        int next1 = 1;
        int next2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = next1 + next2;
            next2 = next1;
            next1 = curr;
        }
        return next1;
    }
}