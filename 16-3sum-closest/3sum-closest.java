class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int psb = nums[0] + nums[1] + nums[2];
        for(int i = 0;i<nums.length - 2;i++){
            int j = i+1;
            int k = nums.length - 1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] == target)return nums[i] + nums[j] + nums[k];
                else if(nums[i] + nums[j] + nums[k] > target){
                    if((nums[i] + nums[j] + nums[k]) - target < Math.abs(target - psb)){
                        psb = nums[i] + nums[j] + nums[k]; 
                    }
                    k--;
                }else{
                    if(target - (nums[i] + nums[j] + nums[k]) < Math.abs(target - psb)){
                        psb = nums[i] + nums[j] + nums[k]; 
                    }
                    j++;
                }
            }
        }
        return psb;
    }
}