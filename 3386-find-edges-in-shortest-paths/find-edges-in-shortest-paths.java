class pair {
    int node;
    int weight;

    pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class pairDist {
    int node;
    int dist;

    pairDist(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        List<List<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            int weight = edges[i][2];
            adj.get(source).add(new pair(destination, weight));
            adj.get(destination).add(new pair(source, weight));
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        PriorityQueue<pairDist> q = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        q.offer(new pairDist(0, 0));
        while (!q.isEmpty()) {
            pairDist temp = q.poll();
            int node = temp.node;
            int dist = temp.dist;
            if (dist > distance[node]) {
                continue;
            }
            for (pair val : adj.get(node)) {
                int next = val.node;
                int weight = val.weight;
                if (distance[next] > dist + weight) {
                    distance[next] = dist + weight;
                    q.offer(new pairDist(next, distance[next]));
                }
            }
        }
        int[] distance2 = new int[n];
        Arrays.fill(distance2, Integer.MAX_VALUE);
        distance2[n - 1] = 0;
        q.offer(new pairDist(n - 1, 0));
        while (!q.isEmpty()) {
            pairDist temp = q.poll();
            int node = temp.node;
            int dist = temp.dist;
            if (dist > distance2[node]) {
                continue;
            }
            for (pair val : adj.get(node)) {
                int next = val.node;
                int weight = val.weight;
                if (distance2[next] > dist + weight) {
                    distance2[next] = dist + weight;
                    q.offer(new pairDist(next, distance2[next]));
                }
            }
        }
        boolean[] ans = new boolean[edges.length];
        int shortest = distance[n - 1];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if (distance[u] != Integer.MAX_VALUE &&
                distance2[v] != Integer.MAX_VALUE &&
                distance[u] + w + distance2[v] == shortest) {
                ans[i] = true;
            }
            if (distance[v] != Integer.MAX_VALUE &&
                distance2[u] != Integer.MAX_VALUE &&
                distance[v] + w + distance2[u] == shortest) {
                ans[i] = true;
            }
        }
        return ans;
    }
}