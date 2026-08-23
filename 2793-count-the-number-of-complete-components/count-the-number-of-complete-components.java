class Solution {
    public static void dfs(int node, boolean[] visited,List<List<Integer>> edges,int[] vertexCount, int[] edgeCount) {
        visited[node] = true;
        vertexCount[0]++;
        edgeCount[0] += edges.get(node).size();
        for (int val : edges.get(node)) {
            if (!visited[val]) {
                dfs(val, visited, edges, vertexCount, edgeCount);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[1];
            adj.get(u).add(w);
            adj.get(w).add(u);
        }
        boolean visited[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] vertexCount = {0};
                int[] edgeCount = {0};
                dfs(i, visited, adj, vertexCount, edgeCount);
                int actualEdges = edgeCount[0] / 2;
                int requiredEdges = vertexCount[0] * (vertexCount[0] - 1) / 2;
                if (actualEdges == requiredEdges) {
                    count++;
                }
            }
        }
        return count;
    }
}