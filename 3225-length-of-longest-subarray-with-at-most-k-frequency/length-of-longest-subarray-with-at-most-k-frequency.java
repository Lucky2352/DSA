class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        int j = 0;
        int maxi = 0;
        while(j < nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            max = Math.max(max,map.get(nums[j]));
            if(max > k){
                int conflict = nums[j];



                while(map.get(nums[j]) > k){
                    map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                    if(map.get(nums[i]) == 0){
                        map.remove(nums[i]);
                    }
                    i++;
                }
            }
                max = map.get(nums[j]);
                j++;
            maxi = Math.max(maxi,j-i);
            
        }
        return maxi;
    }
}