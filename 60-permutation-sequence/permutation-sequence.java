class Solution {
    public static void premutation(int index, int[] nums, boolean[] visited, List<Integer> list,
            List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                list.add(nums[i]);
                premutation(index + 1, nums, visited, list, ans);
                visited[i] = false;
                list.remove(list.size() - 1);
            }

        }
    }
    public String getPermutation(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int nums[] = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        List<Integer> slist = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        premutation(0,nums,visited,slist,ans);
        List<Integer> list = ans.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}