class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int maxi = 0;
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i] + 1)){
                maxi = Math.max(maxi,map.get(nums[i]) + map.get(nums[i] +1));
            }
        }
        return maxi;
    }
}