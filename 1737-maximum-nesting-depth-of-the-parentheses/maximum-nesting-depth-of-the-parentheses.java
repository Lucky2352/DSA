class Solution {
    public int maxDepth(String s) {
        int maxi = 0;
        int cur = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                cur++;
            }else if(s.charAt(i) == ')'){
                maxi = Math.max(cur,maxi);
                cur--;
            }
        }
        return Math.max(maxi,cur);
    }
}