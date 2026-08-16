class Solution {
    public static void recursion(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int x : nums) {
                list.add(x);
            }
            ans.add(list);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            recursion(nums,i+1,ans);
            int chemp = nums[i];
            nums[i] = nums[j];
            nums[j] = chemp;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(nums, 0, ans);
        return ans;
    }
}