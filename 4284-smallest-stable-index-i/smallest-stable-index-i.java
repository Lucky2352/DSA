class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];
        int maxi = nums[0];
        int mini = nums[nums.length - 1];
        for(int i = 0;i<nums.length;i++){
            forward[i] = Math.max(maxi,nums[i]);
            backward[nums.length - 1 - i] = Math.min(nums[nums.length - 1 - i],mini);
            maxi = Math.max(maxi,nums[i]);
            mini = Math.min(nums[nums.length - 1 - i],mini);
        }
        for(int i = 0;i<nums.length;i++){
            if((forward[i] - backward[i]) <= k){
                return i; 
            }
        }
        return -1;
    }
}