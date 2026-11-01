class Solution {
    public int minMoves(int[] nums) {
        if(nums.length == 1)return 0;
        int cur = nums[0];
        int mini = nums[0];
        boolean flag = true;
        int count = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > cur){
                flag = false;
                cur = nums[i];
            }
            if(nums[i] < mini){
                mini = nums[i];
            }
        }
        if(flag)return 0;
        for(int i = 0;i<nums.length;i++){
            count += nums[i] - mini;
        }
        return count;
    }
}