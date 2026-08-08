class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int count = 0;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (count == 1) {
                    return false;
                }

                if (check(s, i + 1, j)) {
                    i++;
                    count++;
                } else if (check(s, i, j - 1)) {
                    j--;
                    count++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}