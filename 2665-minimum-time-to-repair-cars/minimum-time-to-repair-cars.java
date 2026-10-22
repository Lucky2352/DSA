class Solution {
    boolean check(int[] nums, long val, int cars) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (long) Math.sqrt(val / nums[i]);
            if (count >= cars) return true;
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long low = 0;
        long high = (long) ranks[0] * cars * cars;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(ranks, mid, cars)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
