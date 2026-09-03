class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for(int num : nums1){
            min = Math.min(num,min);
        }
        if(min % 2 == 0){
            for(int num : nums1){
                if(num != min){
                    if(num % 2 == 0){
                        continue;
                    }
                    else if(num - min >= 1 && (num - min) % 2 == 0){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }else{
            for(int num : nums1){
                if(num != min){
                    if(num % 2 != 0){
                        continue;
                    }
                    else if(num - min >= 1 && (num - min) % 2 != 0){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}