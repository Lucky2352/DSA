class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                list.add(nums[i]);
                i += 2;
                j += 2;
            }else{
                i++;
                j++;
            }
        }
        return list;
    }
}