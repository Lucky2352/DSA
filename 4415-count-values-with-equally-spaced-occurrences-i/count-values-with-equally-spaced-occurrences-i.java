class Solution {
    public int countSpecialIntegers(int[] nums) {
        int[] freq = new int[101];
        for(int i = 0;i < nums.length;i++){
            freq[nums[i]]++;
        }
        int count = 0;
        for(int J = 1;J <= 100;J++){
            if(freq[J] != 3) continue;
            int i1 = -1;
            int i2 = -1;
            int i3 = -1;
            for(int i = 0;i < nums.length;i++){
                if(nums[i] == J){
                    if(i1 == -1){
                        i1 = i;
                    }else if(i2 == -1){
                        i2 = i;
                    }else{
                        i3 = i;
                    }
                }
            }
            if(i2 - i1 == i3 - i2){
                count++;
            }
        }
        return count;
    }
}