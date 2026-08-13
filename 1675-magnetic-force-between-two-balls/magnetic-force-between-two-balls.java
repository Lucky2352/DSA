class Solution {
    public static boolean check(int[] nums,int n,int k,int val){
        int prev = nums[0];
        int count = 1;
        for(int i = 0;i<n;i++){
            if(nums[i] - prev >= val){
                prev = nums[i];
                count++;
            }
        }
        return count >= k;
    }
    public int maxDistance(int[] stalls, int k) {
      Arrays.sort(stalls);
        int low = 1;
        int high = 0;
        for(int num : stalls){
            if(num > high)high = num;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(stalls,stalls.length,k,mid)){
                low = mid + 1; 
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
}