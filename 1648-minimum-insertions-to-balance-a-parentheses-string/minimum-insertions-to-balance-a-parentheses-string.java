    class Solution {
        public int minInsertions(String s) {
            int count = 0;
            int open = 0;
            int i = 0;
            while (i < s.length()) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    open++;
                    i++;
                } else {
                    if (open <= 0) {
                        if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                            count++;
                            i += 2;
                        } else {
                            count += 2;
                            i++;
                        }
                    } else {
                        if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                            open--;
                            i += 2;
                        } else {
                            count++;
                            open--;
                            i++;
                        }
                    }

                }
            }
            count += open * 2;
            return count;
        }
    }