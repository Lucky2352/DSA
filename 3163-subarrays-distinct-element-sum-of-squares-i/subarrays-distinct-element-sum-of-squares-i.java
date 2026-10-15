class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        for (int i = 0;i < nums.size();i++) {
            boolean[] seen = new boolean[101];
            int distinct = 0;
            for (int j = i;j < nums.size();j++) {
                int num = nums.get(j);
                if (!seen[num]) {
                    seen[num] = true;
                    distinct++;
                }
                ans += distinct * distinct;
            }
        }
        return ans;
    }
}