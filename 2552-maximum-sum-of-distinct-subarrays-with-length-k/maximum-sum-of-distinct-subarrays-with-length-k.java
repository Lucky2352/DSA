class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        long sum = 0;
        long maxi = 0;
        while(j < nums.length){
            if(!set.contains(nums[j])){
                sum += nums[j];
                set.add(nums[j]);
                j++;
            }else{
                while(i < j && nums[i] != nums[j]){
                    sum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
                i++;
                j++;
                
            }
            if(set.size() == k){
                maxi = Math.max(maxi,sum);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            
        }
        return maxi;
    }
}