class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < nums.length(); i++) {
            while (!st.isEmpty() && k > 0 && st.peek() > nums.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(nums.charAt(i));
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}