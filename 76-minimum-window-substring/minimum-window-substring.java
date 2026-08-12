class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] map = new int[128];

        for (int k = 0; k < t.length(); k++) {
            map[t.charAt(k)]++;
        }

        int i = 0;
        int j = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder("");
        int mini = Integer.MAX_VALUE;

        while (j < s.length()) {
            if (map[s.charAt(j)] > 0) {
                count++;
            }

            map[s.charAt(j)]--;

            while (count == t.length()) {
                if (j - i + 1 < mini) {
                    mini = j - i + 1;
                    sb.setLength(0);
                    sb.append(s.substring(i, j + 1));
                }

                map[s.charAt(i)]++;

                if (map[s.charAt(i)] > 0) {
                    count--;
                }

                i++;
            }

            j++;
        }

        return sb.toString();
    }
}