class Solution {
    public static List<List<Integer>> recursion(int nums[],int i,List<Integer> list,List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(list));
            return ans;
        }
        list.add(nums[i]);
        List<List<Integer>> left = recursion(nums,i + 1,list,ans);
        list.remove(list.size() - 1);
        List<List<Integer>> right = recursion(nums,i + 1,list,ans);
        return ans;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        return recursion(nums,0,new ArrayList<>(),list);
    }
}