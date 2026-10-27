class Solution {
    public static void recursion(int index, String num, int target, List<String> list, String ans, long cur, long prev) {
        if (index == num.length()) {
            if (cur == target) {
                list.add(ans);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            String part = num.substring(index, i + 1);
            long val = Long.parseLong(part);
            if (index == 0) {
                recursion(i + 1, num, target, list, part, val, val);
            } else {
                recursion(i + 1, num, target, list, ans + "+" + part, cur + val, val);
                recursion(i + 1, num, target, list, ans + "-" + part, cur - val, -val);
                recursion(i + 1, num, target, list, ans + "*" + part, cur - prev + (prev * val), prev * val);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return list;
        }
        recursion(0, num, target, list, "", 0, 0);
        return list;
    }
}