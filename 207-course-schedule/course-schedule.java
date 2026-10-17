class Solution {
    public boolean canFinish(int V, int[][] matrix) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[V];
        for (int i = 0; i < matrix.length; i++) {
            indeg[matrix[i][1]]++;
            adj.get(matrix[i][0]).add(matrix[i][1]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];
        for(int i = 0;i<V;i++){
            if(indeg[i] == 0){
                q.offer(i);
                
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            visited[temp] = true;
            for(int val : adj.get(temp)){
                if(indeg[val] > 0)indeg[val]--;
                if(indeg[val] == 0){
                    q.offer(val);
                }
            }
        }
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}