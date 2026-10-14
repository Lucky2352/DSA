class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) return "";
        StringBuilder sb = new StringBuilder("");
        while (sum > 0) {
            if (sum >= 9) {
                sb.append('9');
                sum -= 9;
            } else {
                sb.append((char) ('0' + sum));
                sum = 0;
            }
        }
        if (sb.length() > num) return "";
        while (sb.length() < num) {
            sb.append('0');
        }
        return sb.toString();
    }
}