class Solution {
    public static boolean check(int[] nums,int k,long val){
        long count = 0;
        for(int num : nums){
            count += val/num;
        }
        return count >= k;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long low = Integer.MAX_VALUE;
        long high = 0;
        for(int num : time){
            low = Math.min(num,low);
            high = Math.max(num,high);
        }
        high *= totalTrips;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(check(time,totalTrips,mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}