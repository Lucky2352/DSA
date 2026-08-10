class Solution {
    public static void recursion(int i,int target,List<Integer> list,List<List<Integer>> ans,int[] nums){
        if(i == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
                return;
            }
            return;
        }
        if(target - nums[i] >= 0){
            list.add(nums[i]);
            recursion(i,target - nums[i],list,ans,nums);
            list.remove(list.size() - 1);
        }
        recursion(i+1,target,list,ans,nums);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recursion(0,target,list,ans,nums);
        return ans;
    }
}