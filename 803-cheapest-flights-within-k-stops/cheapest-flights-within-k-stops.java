class pair {
    int d;
    int w;

    public pair(int d, int w) {
        this.d = d;
        this.w = w;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] f, int src, int dst, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < f.length; i++) {
            adj.get(f[i][0]).add(new pair(f[i][1], f[i][2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(src, 0));
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            for(int i = 0;i < size;i++) {
                pair temp = q.poll();
                int cur = temp.d;
                int cost = temp.w;
                for (pair val : adj.get(cur)) {
                    int next = val.d;
                    int newCost = cost + val.w;
                    if (newCost < dist[next]) {
                        dist[next] = newCost;
                        q.offer(new pair(next, newCost));
                    }
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}