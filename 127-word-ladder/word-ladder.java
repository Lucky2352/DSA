class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        if(!set.contains(endWord)) return 0;
        int maxi = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        if(set.contains(beginWord)){
        set.remove(beginWord);
        }
        while(!q.isEmpty()){
            int len = q.size();
            for(int p = 0;p<len;p++){
            String s = q.poll();
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0;i<s.length();i++){
                char old = sb.charAt(i);
                for(int j = 0;j<26;j++){
                    sb.setCharAt(i,(char)(j + 'a'));
                    if(sb.toString().equals(endWord))return maxi+1;
                    if(set.contains(sb.toString())){
                        q.offer(sb.toString());
                        set.remove(sb.toString());
                    }
                }
                sb.setCharAt(i, old);
            }
            }
            maxi++;
        }
        return 0;
    }
}