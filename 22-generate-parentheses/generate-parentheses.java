class Solution {
    List<String> list = new ArrayList<>();
    void generate(int i,int n,String s,int open,int close){
        if(i == 2*n){
            if(open == n){
                list.add(s);
                return;
            }
            return;
        }
        if(open < n){
            generate(i+1,n,s + '(',open + 1,close);
        }
        if(close < open){
            generate(i+1,n,s + ')',open,close + 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        generate(0,n,"",0,0);
        return list;
    }
}