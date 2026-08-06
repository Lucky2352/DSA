class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)return 0;
        int i = 0;
        int j = 0;
        int max = 1;
        int[] arr = new int[256];
        while(j < s.length()){
            if(arr[s.charAt(j)] == 0){
                arr[s.charAt(j)]++;
                j++;
            }else{
                max = Math.max(max,j - i);
                while(i < j && s.charAt(i) != s.charAt(j)){
                    arr[s.charAt(i)]--;
                    i++;
                }
                if(i < s.length()- 1){
                    arr[s.charAt(i)]--;
                    i++;
                }
            }
        }
        max = Math.max(max,j - i);
        return max;
    }
}