class Solution {
    String recursion(int j,int n,StringBuilder s){
        if(j >= n){
            return s.toString();
        }
        StringBuilder sb = new StringBuilder();
        int cur = s.charAt(0) - '0';
        int count = 1;
        for(int i = 1;i<s.length();i++){
            if(cur == (s.charAt(i) - '0')){
                count++;
            }else{
                sb.append(Integer.toString(count));
                count = 1;
                sb.append(Integer.toString(cur));
                cur = s.charAt(i) - '0';
            }
        }
        sb.append(Integer.toString(count));
        sb.append(Integer.toString(cur));
        return recursion(j+1,n,sb);
    }
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        if(n == 1) return sb.toString();
        return recursion(1,n,sb);
    }
}