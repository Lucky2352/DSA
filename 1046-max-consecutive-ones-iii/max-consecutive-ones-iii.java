class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < nums.length){
            if(nums[j] == 1){
                j++;
            }else{
                if(k > 0){
                    k--;
                    j++;
                }else{
                    max= Math.max(max,j - i);
                    while(i <= j && nums[i] != 0){
                        i++;
                    }
                    k++;
                    i++;
                }
            }
        }
        return Math.max(j- i,max);
    }
}