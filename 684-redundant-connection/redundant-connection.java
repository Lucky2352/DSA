class Solution {

    boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, int destination) {
        visited[node] = true;

        for(int val : adj.get(node)) {
            if(!visited[val]) {
                if(val == destination) {
                    return true;
                }
                if(dfs(val, adj, visited, destination)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int m = edges.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n + 2; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {

            int f = edges[i][0];
            int s = edges[i][1];

            boolean[] visited = new boolean[n + 1];

            if(dfs(f, adj, visited, s)) {
                return new int[] {f, s};
            }

            adj.get(f).add(s);
            adj.get(s).add(f);
        }

        return new int[] {-1, -1};
    }
}