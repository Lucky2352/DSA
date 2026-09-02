class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int i = 0;
        int j = (nums.size() + 1) / 2;
        int count = 0;
        while (i < nums.size() / 2 && j < nums.size()) {
            if (nums.get(i) < nums.get(j)) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return nums.size() - 2 * count;
    }
}