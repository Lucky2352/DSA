class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        if(nums.length == 1)return nums[0];
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high])ans = Math.min(ans,nums[low]);
            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }
            
            if(nums[low] <= nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid + 1;
            }else{
                ans = Math.min(nums[mid],ans);
                high = mid - 1;
            }
        }
        return ans;
    }
}