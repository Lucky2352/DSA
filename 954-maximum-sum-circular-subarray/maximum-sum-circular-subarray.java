class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int totalArray = 0;
        for(int i = 0;i<nums.length;i++){
            totalArray += nums[i];
            sum += nums[i];
            maxi = Math.max(maxi,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        if(maxi<0){
            return maxi;
        }
        int mini = Integer.MAX_VALUE;
        int sum2 = 0;
        for(int i = 0;i<nums.length;i++){
            sum2=Math.min(nums[i],nums[i]+sum2);
            mini = Math.min(mini, sum2);
        }
        return Math.max(maxi,totalArray - mini);
    }
}