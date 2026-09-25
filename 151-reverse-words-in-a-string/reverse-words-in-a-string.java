class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder("");
        int i = s.length() - 1;
        int prev = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
            prev--;
        }
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, prev + 1));
                while (i >= 0 && s.charAt(i) == ' ') {
                    i--;
                    prev--;
                }
                prev = i;
                sb.append(' ');
            }
            else{
                i--;
            }
        }
        sb.append(s.substring(i+1,prev+1));
        for(int j = sb.length() - 1;j>= 0;j--){
            if(sb.charAt(j) == ' '){
                sb.deleteCharAt(j);
            }else{
                break;
            }
        }
        return sb.toString();
    }
}