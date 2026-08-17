class Solution {
    public static int ans(int[] nums1, int[] nums2, int k) {
        int low = Math.max(0, k - nums2.length);
        int high = Math.min(k, nums1.length);
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;
            if (mid1 > 0 && mid2 < nums2.length &&
                nums1[mid1 - 1] > nums2[mid2]) {

                high = mid1 - 1;
                continue;
            }
            if (mid2 > 0 && mid1 < nums1.length &&
                nums2[mid2 - 1] > nums1[mid1]) {

                low = mid1 + 1;
                continue;
            }

            if (mid1 == 0) {
                return nums2[mid2 - 1];
            }
            if (mid2 == 0) {
                return nums1[mid1 - 1];
            }
            return Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
        }
        return -1;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen % 2 == 1) {
            int k = totalLen / 2 + 1;
            return ans(nums1, nums2, k);
        }
        int k1 = totalLen / 2;
        int k2 = k1 + 1;
        return (ans(nums1,nums2,k1) + ans(nums1,nums2,k2))/2.0;
    }
}