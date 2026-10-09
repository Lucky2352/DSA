    class Solution {
        public int minInsertions(String s) {
            int count = 0;
            Stack<Character> st = new Stack<>();
            int i = 0;
            while (i < s.length()) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    st.push(ch);
                    i++;
                } else {
                    if (st.isEmpty()) {
                        if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                            count++;
                            i += 2;
                        } else {
                            count += 2;
                            i++;
                        }
                    } else {
                        if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                            st.pop();
                            i += 2;
                        } else {
                            count++;
                            st.pop();
                            i++;
                        }
                    }

                }
            }
            count += st.size() * 2;
            return count;
        }
    }