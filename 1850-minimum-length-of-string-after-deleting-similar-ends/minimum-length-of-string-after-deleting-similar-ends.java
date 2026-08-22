class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            char temp = s.charAt(left);
            while (left <= right && s.charAt(left) == temp) {
                left++;
            }
            while (left <= right && s.charAt(right) == temp) {
                right--;
            }
        }
        return right - left + 1;
    }
}