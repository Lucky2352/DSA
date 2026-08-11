class Solution {
    public static boolean check(int[] nums,int days,int possible){
        int val = possible;
        int count = 1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] <= val){
                val -= nums[i];
            }else{
                count++;
                val = possible;
                val -= nums[i];
            }
        }
        return count <= days;
    }
    public int shipWithinDays(int[] nums, int days) {
        int low = 1;
        int high = 0;
        for(int num : nums){
            high += num;
            if(num > low)low = num;
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(nums,days,mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}