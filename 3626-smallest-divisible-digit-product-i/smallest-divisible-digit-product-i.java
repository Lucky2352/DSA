class Solution {
    public int smallestNumber(int n, int t) {
        for(int i = n;i<= Integer.MAX_VALUE;i++){
            int orignal = i;
            int product = 1;
            while(orignal != 0){
                int rem = orignal % 10;
                product *= rem;
                orignal /= 10;
            }
            if((product % t)== 0) return i;
        }
        return -1;
    }
}