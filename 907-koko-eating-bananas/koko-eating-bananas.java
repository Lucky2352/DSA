class Solution {
    public static long check(int[]nums,int k){
        long hour = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] % k == 0){
                hour += nums[i]/k;
            }else{
                hour += (nums[i]/k) + 1;
            }   
        }
        return hour;
    }
    public int minEatingSpeed(int[] p, int h) {
        int low = 1;
        int high = 0;
        for(int num : p){
            if(num > high)high = num;
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(p,mid) <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}