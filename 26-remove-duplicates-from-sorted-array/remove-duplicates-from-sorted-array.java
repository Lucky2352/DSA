class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        if(nums.length==0) return 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[left]!=nums[i]){
                left++;
                nums[left] = nums[i];
            } 
        }
        return left + 1;
    }
}