class Solution {
    public int repeatedStringMatch(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(0))
                continue;
            int k = i;
            int j = 0;
            while (j < b.length() &&
                   a.charAt(k % a.length()) == b.charAt(j)) {
                k++;
                j++;
            }
            if (j == b.length()) {
                return (k + a.length() - 1) / a.length();
            }
        }
        return -1;
    }
}