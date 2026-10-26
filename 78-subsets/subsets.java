class Solution {
    public static void recursion(int i,int n,int[] nums,List<Integer> list ,List<List<Integer>> st){
        if(i == n){
            st.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        recursion(i +1,n,nums,list,st);
        list.remove(list.size() - 1);
        recursion(i +1,n,nums,list,st);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recursion(0,nums.length,nums,list,ans);
        return ans;
    }
}