class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(count != 0){
                    sb.append(ch);
                }
                count++;
            }else{
                if(count != 1){
                    sb.append(ch);
                }
                count--;
            }
        }
        return sb.toString();
    }
}