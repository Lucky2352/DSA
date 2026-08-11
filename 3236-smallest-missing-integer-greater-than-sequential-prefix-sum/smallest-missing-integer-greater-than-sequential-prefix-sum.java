class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        int sum = nums[0];
        int cur = 1;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            set.add(nums[i]);

            if (nums[i] - nums[0] == cur && flag) {
                sum += nums[i];
                cur++;
            }else{
                flag = false;
            }
        }
        int cur2 = 0;
        while (set.contains(sum + cur2)) {
            cur2++;
        }
        return sum + cur2;
    }
}