class Solution { 
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] freq = new int[26];
            for (char ch : s1.toCharArray()) {
                freq[ch - 'a']--;
            }
            for (int j = i; j < i + s1.length(); j++) {
                char ch = s2.charAt(j);
                freq[ch - 'a']++;
            }
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (freq[j] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }
        return false;
    }
}