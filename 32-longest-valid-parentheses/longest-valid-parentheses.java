class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int maxi = 0;
        int start = -1;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
                i++;
            }else{
                if(st.isEmpty()){
                    start = i;
                }else{
                    st.pop();
                    if(st.isEmpty()){
                        maxi = Math.max(maxi,i - start);
                    }else{
                        maxi = Math.max(maxi,i - st.peek());
                    }
                }
                i++;
            }
        }
        return maxi;
    }
}