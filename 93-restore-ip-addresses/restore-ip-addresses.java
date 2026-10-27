class Solution {
    boolean isValid(String s) {
        String arr[] = s.split("\\.");
        if (arr.length != 4) return false;
        for (String temp : arr) {
            if (temp.length() < 1 || temp.length() > 3) return false;
            if (temp.length() > 1 && temp.charAt(0) == '0') return false;
            int val = Integer.parseInt(temp);
            if (val > 255) return false;
        }
        return true;
    }
    void recursion(int i, List<String> ans, String cur, String s) {
        if (i == s.length()) {
            if (cur.length() > 0 && cur.charAt(cur.length() - 1) == '.') {
                cur = cur.substring(0, cur.length() - 1);
            }
            if (isValid(cur)) {
                ans.add(cur);
            }
            return;
        }
        if (cur.length() > 0 && cur.split("\\.").length == 4) return;
        cur = cur + s.charAt(i) + '.';
        recursion(i + 1, ans, cur, s);
        cur = cur.substring(0, cur.length() - 2);
        if (i + 1 < s.length()) {
            cur = cur + s.substring(i, i + 2) + '.';
            recursion(i + 2, ans, cur, s);
            cur = cur.substring(0, cur.length() - 3);
        }

        if (i + 2 < s.length()) {
            cur = cur + s.substring(i, i + 3) + '.';
            recursion(i + 3, ans, cur, s);
            cur = cur.substring(0, cur.length() - 4);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        recursion(0, ans, "", s);
        return ans;
    }
}