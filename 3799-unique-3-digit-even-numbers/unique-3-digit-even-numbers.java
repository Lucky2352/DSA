class Solution {
    Set<Integer> set = new HashSet<>();
    public void recursion(int count, int[] nums, boolean[] visited, int num) {
        if (count == 3) {
            if (num % 2 == 0) {
                set.add(num);
            }
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!visited[j]) {
                if (count == 0 && nums[j] == 0) {
                    continue;
                }
                visited[j] = true;
                recursion(count + 1, nums, visited, num * 10 + nums[j]);
                visited[j] = false;
            }
        }
    }
    public int totalNumbers(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        recursion(0, nums, visited, 0);
        return set.size();
    }
}