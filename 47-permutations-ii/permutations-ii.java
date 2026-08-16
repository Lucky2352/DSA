class Solution {
    public static void recursion(int[] nums, int i, boolean[] visited,List<Integer> list, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visited[j] || j > 0 && nums[j] == nums[j - 1] && !visited[j - 1])continue;
            if (!visited[j]) {
                visited[j] = true;
                list.add(nums[j]);
                recursion(nums, i + 1, visited, list, ans);
                list.remove(list.size() - 1);
                visited[j] = false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        recursion(nums, 0, visited, list, ans);
        return ans;
    }
}