
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a < 3 && b < 3) {
            for (int i = 0; i < a; i++) {
                sb.append('a');
            }
            for (int i = 0; i < b; i++) {
                sb.append('b');
            }
            return sb.toString();
        }
        if (a >= b) {
            while (a > 0 && b > 0) {
                if (a >= 2 && a >= b) {
                    sb.append("aab");
                    a -= 2;
                    b--;
                } else {
                    sb.append("ab");
                    a--;
                    b--;
                }
            }
            while (a > 0) {
                sb.append('a');
                a--;
            }
            while (b > 0) {
                sb.append('b');
                b--;
            }
        } else {
            while (a > 0 && b > 0) {
                if (b >= 2 && b >= a) {
                    sb.append("bba");
                    b -= 2;
                    a--;
                } else {
                    sb.append("ba");
                    b--;
                    a--;
                }
            }
            while (a > 0) {
                sb.append('a');
                a--;
            }
            while (b > 0) {
                sb.append('b');
                b--;
            }
        }
        return sb.toString();
    }
}
