class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(valueDiff == 0 && set.size() == nums.length)return false;
        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1;j<i+1+indexDiff;j++){
                if(j>=nums.length)break;
                if(Math.abs((long)(nums[i] - nums[j])) <= valueDiff)return true;
            }
        }
        return false;
    }
}