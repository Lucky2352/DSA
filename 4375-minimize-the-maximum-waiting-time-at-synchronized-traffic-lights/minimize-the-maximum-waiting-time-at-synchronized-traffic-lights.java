class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxi = Integer.MIN_VALUE;
        int penalty = 0;
        for (int i = 0;i < lights.length;i++) {
            maxi = Math.max(lights[i], maxi);
        }
        for (int i = 0;i < arrivalTime.length;i++) {
            int r = arrivalTime[i] % period;
            if (r >= maxi) {
                penalty = Math.max(penalty, period - r);
            }
        }
        return penalty;
    }
}