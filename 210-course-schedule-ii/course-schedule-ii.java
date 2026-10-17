class Solution {
    public int[] findOrder(int V, int[][] matrix) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[V];
        for (int i = 0; i < matrix.length; i++) {
            indeg[matrix[i][0]]++;
            adj.get(matrix[i][1]).add(matrix[i][0]);
        }
        int[] ans = new int[V];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            ans[count] = temp;
            count++;
            for(int val : adj.get(temp)){
                indeg[val]--;
                if(indeg[val] == 0){
                    q.offer(val);
                }
            }
        }
        if(count != V)return new int[] {};
        return ans;
    }
}