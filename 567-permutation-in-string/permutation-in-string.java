class Solution { 
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char ch : s1.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }
            for (int j = i; j < i + s1.length(); j++) {
                char ch = s2.charAt(j);
                int count = map.getOrDefault(ch, 0) + 1;
                if (count == 0) {
                    map.remove(ch);
                } else {
                    map.put(ch, count);
                }
            }
            if (map.size() == 0) {
                return true;
            }
        }
        return false;
    }
}