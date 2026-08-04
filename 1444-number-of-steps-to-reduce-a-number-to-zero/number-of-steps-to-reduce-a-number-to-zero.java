class Solution {
    public static int recursion(int n,int count){
        if(n == 0)return count;
        if(n % 2 == 0)return recursion(n/2,count + 1);
        return recursion(n-1,count+1);
    }
    public int numberOfSteps(int num) {
        if(num == 0)return 0;
        return recursion(num,0);
    }
}