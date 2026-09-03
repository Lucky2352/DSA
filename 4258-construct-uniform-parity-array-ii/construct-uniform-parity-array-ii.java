class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for(int num : nums1){
            min = Math.min(min,num);
            if(num % 2 != 0)flag = true;
        }
        if(min % 2 == 1)return true;
        
        return !flag;
    }
}