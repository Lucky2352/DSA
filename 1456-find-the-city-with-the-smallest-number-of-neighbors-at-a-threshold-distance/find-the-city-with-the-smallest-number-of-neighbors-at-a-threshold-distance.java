class Solution {
    int dijkstra(List<List<int[]>> adj, int src, int th) {
        int V = adj.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];
            if (d > dist[u])
                continue;
            for (int[] p : adj.get(u)) {
                int v = p[0];
                int w = p[1];
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int count = 0;

        for (int i = 0; i < V; i++) {
            if (i != src && dist[i] <= th)
                count++;
        }

        return count;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        int ans = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = dijkstra(adj, i, distanceThreshold);

            if (count <= minCount) {
                minCount = count;
                ans = i;
            }
        }
        return ans;
    }
}
