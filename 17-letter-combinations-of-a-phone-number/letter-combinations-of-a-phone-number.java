class Solution {
    public static void recursion(String p, String up, String[] arr, List<String> list) {
        if (up.isEmpty()) {
            list.add(p);
            return;
        }
        String psb = arr[up.charAt(0) - '0'];
        for (int i = 0; i < psb.length(); i++) {
            recursion(
                p + psb.charAt(i),
                up.substring(1),
                arr,
                list
            );
        }
    }
    public List<String> letterCombinations(String d) {
        if (d.length() == 0) return new ArrayList<>();
        String[] arr = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> ans = new ArrayList<>();
        recursion("", d, arr, ans);
        return ans;
    }
}