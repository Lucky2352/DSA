class Solution {
    public String longestWord(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String temp : words){
            map.put(temp,1);
        }
        String str = "";
        for (String word : words) {
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                if (!map.containsKey(prefix)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (word.length() > str.length() || (word.length() == str.length() && word.compareTo(str) < 0)) {
                    str = word;
                }
            }
        }
        return str;
    }
}