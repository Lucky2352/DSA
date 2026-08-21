class Solution {
    public boolean canArrange(int[] arr, int k){
        int[] freq = new int[k];
        for(int num : arr){
            int rem = num % k;
            if (rem < 0) rem += k;
            freq[rem]++;
        }
        if(freq[0] % 2 != 0)return false;
        for (int r = 1; r <= k/2; r++){
            if (freq[r] != freq[k - r]){
                return false;
            }
        }
        return true;
    }
}