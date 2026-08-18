class Solution {
    public static boolean check(int[] nums,int val,double hr){
        double count = 0;
        for(int i = 0;i<nums.length;i++){
            if(i == nums.length - 1){
                count += nums[i]/(val*1.0);
            }
            else if(nums[i] % val == 0){
                count += nums[i]/(val*1.0);
            }else{
                count += nums[i]/(val);
                count++;
            }
        }
        return count <= hr; 
    }
    public int minSpeedOnTime(int[] nums, double hour) {
        if(hour <= nums.length-1) return -1;
        int low = 1;
        int high = 10000000;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(nums,mid,hour)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid +1;
            }
    }
    return ans;
    }
}