class Solution {
    public static void recursion(int nums[],int i,List<Integer> list,List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        recursion(nums,i+1,list,ans);
        list.remove(list.size() - 1);
        recursion(nums,i+1,list,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(nums,0,new ArrayList<>(),list);
        return list;
    }
}