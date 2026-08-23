class Solution {
    public String mergeAlternately(String s, String t) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder("");
        while(i < s.length() && j < t.length()){
                sb.append(s.charAt(i));
                i++;
                sb.append(t.charAt(j));
                j++;
        }
        while(i < s.length()){
            sb.append(s.charAt(i));
            i++;
        }
        while(j < t.length()){
            sb.append(t.charAt(j));
            j++;
        }
        return sb.toString();
    }
}