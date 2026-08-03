class Solution {
    public static void rev(int[] nums,int st,int end){
        while(st < end){
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rev(nums,0,nums.length - 1);
        rev(nums,0,k - 1);
        rev(nums,k,nums.length - 1);
    }
}