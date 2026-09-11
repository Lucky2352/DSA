class Solution {
    boolean[] used = new boolean[10];
    boolean[] seen = new boolean[1000];
    public void recursion(int count, int num, int[] nums) {
        if (count == 3) {
            seen[num] = true;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (count == 0 && nums[i] == 0) {
                continue;
            }
            if (count == 2 && nums[i] % 2 != 0) {
                continue;
            }
            used[i] = true;
            recursion(count + 1, num * 10 + nums[i], nums);
            used[i] = false;
        }
    }
    public int totalNumbers(int[] nums) {
        recursion(0, 0, nums);
        int ans = 0;
        for (int i = 100; i < 1000; i++) {
            if (seen[i]) {
                ans++;
            }
        }
        return ans;
    }
}