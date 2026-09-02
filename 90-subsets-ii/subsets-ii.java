class Solution {
    public static void recursion(int i,int n,int[] nums,List<Integer> list ,Set<List<Integer>> st){
        if(i == n){
            st.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        recursion(i +1,n,nums,list,st);
        list.remove(list.size() - 1);
        recursion(i +1,n,nums,list,st);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> st = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        recursion(0,nums.length,nums,list,st);
        return new ArrayList(st);
    }
}