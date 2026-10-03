class Solution {
    boolean flag = false;
    public void dfs(int node, int destination, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if(node == destination){
            flag = true;
            return;
        }

        for(int i = 0;i<adj.get(node).size();i++){
            if(!visited[adj.get(node).get(i)]){
                visited[adj.get(node).get(i)] = true;
                dfs(adj.get(node).get(i),destination,adj,visited);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
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
        boolean[] visited = new boolean[n];
        dfs(source, destination, adj, visited);
        return flag;
    }
}