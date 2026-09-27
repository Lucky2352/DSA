class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(sb.toString());
                sb.setLength(0);
            }
            else if(s.charAt(i) == ')'){
                sb.reverse();
                sb.insert(0, st.pop());
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}