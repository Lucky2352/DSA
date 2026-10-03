class Solution {
    long globalCount = 0;
    void bfs(int curr,ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(curr);
        vis[curr] = true;
        
        while (!q.isEmpty()) {
            Integer i = q.poll();
            globalCount++;
            vis[i] = true;
            for (Integer n : adj.get(i)) {
                if (!vis[n]) {
                    q.offer(n);
                    vis[n] = true;
                }
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        
        long prev = 0;
        long sum = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!visited[i]){
            bfs(i,adj,visited);
            }
            sum += (globalCount - prev) * (n - globalCount);
            prev = globalCount;
        }
        return sum;
    }
}