class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                map.put(nums1[i] + nums2[j],map.getOrDefault(nums1[i] + nums2[j],0)+1);
            }
        }

        for(int k = 0;k<n;k++){
                    for(int l = 0;l<n;l++){
                        if(map.containsKey((-1 * (nums3[k] + nums4[l])))){
                            count += map.get((-1 * (nums3[k] + nums4[l])));
                        }
                    }
                }
        return count;
    }
}