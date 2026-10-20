class Solution {
    public int findCircleNum(int[][] ed) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=ed.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<ed.length;i++){
            for(int j = 0;j<ed[0].length;j++){
                if(ed[i][j] == 1 && i != j){
                    adj.get(i + 1).add(j+1);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        boolean visited[] = new boolean[ed.length +1];
        for(int i = 1;i<=ed.length;i++){
            if(!visited[i]){
                visited[i] = true;
                q.offer(i);
                count++;
            }
            while(!q.isEmpty()){
                int temp = q.poll();
                for(int val : adj.get(temp)){
                    if(!visited[val]){
                        visited[val] = true;
                        q.offer(val);
                    }
                }
            }
        }
        return count;
    }
}