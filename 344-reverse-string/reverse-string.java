class Solution {
    void recursion(char[] s,int st,int end){
        if(st > end)return;
        char temp = s[st];
        s[st] = s[end];
        s[end] = temp;
        recursion(s,st + 1,end -  1);
    }
    public void reverseString(char[] s) {
       recursion(s,0,s.length - 1);
    }
}