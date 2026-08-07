class Solution {
    public static void recursion(String digits,int index,StringBuilder current,String[] arr,List<String> list) {
        if (index == digits.length()) {
            list.add(current.toString());
            return;
        }
        String letters = arr[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            recursion(digits, index + 1, current, arr, list);
            current.deleteCharAt(current.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        String[] arr = {"", "", "abc", "def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> ans = new ArrayList<>();
        recursion(digits, 0, new StringBuilder(), arr, ans);
        return ans;
    }
}
