class Solution {
    public static int lowerBound(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int ans = list.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int lengthOfLIS(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = lowerBound(list, nums[i]);

            if (index == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }
}