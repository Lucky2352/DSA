class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int target = total - x;
        if (target < 0) {
            return -1;
        }
        int j = 0;
        int sum = 0;
        int maxi = -1;
        for (int i = 0; i < nums.length;i++) {
            sum += nums[i];
            while (sum > target) {
                sum -= nums[j];
                j++;
            }
            if (sum == target) {
                maxi = Math.max(maxi,i - j + 1);
            }
        }
        if(maxi == -1)return -1;
        return nums.length - maxi;
    }
}