class Solution {
    public static boolean isValid(String str) {
        str = str.substring(0, str.length() - 1);
        String[] parts = str.split("\\.");
        for (String part : parts) {
            if (part.length() > 1 && part.charAt(0) == '0')
                return false;
            int num = Integer.parseInt(part);
            if (num > 255)
                return false;
        }
        return true;
    }
    public static void recursion(StringBuilder sb, String s,List<String> ans, int i, int parts) {
        if (parts > 4)
            return;
        if (i == s.length()) {
            if (parts == 4) {
                String possible = sb.toString();
                if (isValid(possible)) {
                    ans.add(possible.substring(0, possible.length() - 1));
                }
            }
            return;
        }
        sb.append(s.charAt(i));
        sb.append('.');
        recursion(sb, s, ans, i + 1, parts + 1);
        sb.delete(sb.length() - 2, sb.length());


        if (i + 2 <= s.length()) {
            sb.append(s.substring(i, i + 2));
            sb.append('.');
            recursion(sb, s, ans, i + 2, parts + 1);
            sb.delete(sb.length() - 3, sb.length());
        }


        if (i + 3 <= s.length()) {
            sb.append(s.substring(i, i + 3));
            sb.append('.');
            recursion(sb, s, ans, i + 3, parts + 1);
            sb.delete(sb.length() - 4, sb.length());
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        recursion(new StringBuilder(), s, ans, 0, 0);
        return ans;
    }
}