class Solution {
    public boolean checkDivisibility(int n) {
        int product = 1;
        int sum = 0;
        int temp = n;
        while(n != 0){
            int digi = n % 10;
            product *= digi;
            sum += digi;
            n /= 10;
        }
        if(temp % (sum + product) == 0)return true;
        return false;
    }
}