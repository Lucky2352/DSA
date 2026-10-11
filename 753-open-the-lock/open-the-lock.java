class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> d = new HashSet<>();
        Set<String> v = new HashSet<>();
        for(String temp : deadends){
            d.add(temp);
        }
        if(d.contains("0000"))return -1;
        Queue<String> q = new LinkedList<>();
        int count = 0;
        q.offer("0000");
        v.add("0000");
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0;j<size;j++){
                String cur = q.poll();
                if(cur.equals(target))return count;
                for(int i = 0;i<4;i++){
                    char ch = cur.charAt(i);
                    char[] arr = cur.toCharArray();
                    if(ch == '0'){
                        arr[i] = '9';
                    }else{
                        arr[i] = (char)(ch - 1);
                    }
                    String down = new String(arr);
                    if(!d.contains(down) && !v.contains(down)){
                        v.add(down);
                        q.offer(down);
                    }
                    arr = cur.toCharArray();
                    if(ch == '9'){
                        arr[i] = '0';
                    }else{
                        arr[i] = (char)(ch + 1);
                    }
                    String up = new String(arr);
                    if(!d.contains(up) && !v.contains(up)){
                        v.add(up);
                        q.offer(up);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}