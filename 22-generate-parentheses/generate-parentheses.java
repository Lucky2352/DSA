class Solution {
    List<String> list = new ArrayList<>();
    public void generate(int n,int open,int close,String s){
        if(open == n && close == n) {
            list.add(s);
            return;
        }
        if(open < n){
            generate(n,open + 1,close,s + '(');
        }
        if(close < open){
            generate(n,open,close + 1,s + ')');
        }
    }
    public List<String> generateParenthesis(int n) {
        generate(n,0,0,"");
        return list;
    }
}