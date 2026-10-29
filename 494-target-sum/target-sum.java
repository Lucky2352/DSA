class Solution {
    int recursion(int i,int target,int[] nums){
        if(i == nums.length){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        int left = recursion(i+1,target - nums[i],nums);
        int right = recursion(i+1,target + nums[i],nums);
        return left + right;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        return recursion(0,target,nums);
    }
}