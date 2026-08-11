class Solution {
    public String removeOuterParentheses(String s) {
        int open = 1;
        StringBuilder sb = new StringBuilder("");
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) =='('){
                open++;
                if(open != 1){
                    sb.append(s.charAt(i));
                }
            }else{
                if(open == 1){
                    open--;
                }else{
                    sb.append(')');
                    open--;
                }
            }
        }
        return sb.toString();
    }
}