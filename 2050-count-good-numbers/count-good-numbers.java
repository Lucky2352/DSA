class Solution {
    long MOD = 1000000007;
    public long recursion(long x,long y){
        if(y == 0)return 1;
        if(y == 1)return x;
        if(y % 2 == 0){
            long ans = recursion(x,y/2);
            return (ans * ans)% MOD;
        }else{
            long ans = recursion(x,y/2);
            return (x * (ans * ans)%MOD)%MOD;
        }
    }
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        return (int) ((recursion(5, even) * recursion(4, odd)) % MOD);
    }
}