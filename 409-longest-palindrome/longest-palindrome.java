class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[123];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        int count = 0;
        boolean count1 = false;
        for (int i = 65; i < 123; i++) {
            if (freq[i] % 2 == 0) {
                count += freq[i];
            } else {
                count += freq[i] - 1;
                count1 = true;
            }
        }
        if (count1) {
            count++;
        }

        return count;
    }
}