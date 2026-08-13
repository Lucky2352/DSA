class Solution {
    public static int check(int[] nums,int k,int val){
        int possible = val;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] <= possible){
                possible -= nums[i];
            }else{
                k--;
                possible = val - nums[i];
            }
        }
        k--;
        if(k >= 0)return 0;

        return -1;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num : nums){
            high += num;
            if(num > low)low = num;
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(nums,k,mid) != -1){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
    return ans;
    }
}