class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1;i<=Math.pow(2,nums.length);i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<nums.length;j++){
               if((i & (1 << j)) != 0){
                list.add(nums[j]);
               }
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}