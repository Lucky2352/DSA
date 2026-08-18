class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<num.length();i++){
            while(!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k > 0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        for(int i = 0;i<sb.length();i++){
            if(sb.charAt(i) == '0'){
                sb.deleteCharAt(i);
                i--;
            }else{
                break;
            }
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}