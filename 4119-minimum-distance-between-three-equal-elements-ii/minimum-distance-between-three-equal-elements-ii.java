class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            List<Integer> list = map.get(nums[i]);
            list.add(i);
            if (list.size() >= 3) {
                int n = list.size();
                int distance = 2 * (list.get(n - 1) - list.get(n - 3));
                ans = Math.min(ans, distance);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}