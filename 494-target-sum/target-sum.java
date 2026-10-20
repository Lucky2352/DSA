class Solution {
    int count = 0;
    void recursion(int i,int target,int[] nums){
        if(i == nums.length){
            if(target == 0){
                count++;
            }
            return;
        }
        recursion(i+1,target - nums[i],nums);
        recursion(i+1,target + nums[i],nums);
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        recursion(0,target,nums);
        return count;
    }
}