class DSU {
    int[] parent;
    int[] size;
    int count = 0; 

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    void merge(int x, int y) {
        int rootA = find(x);
        int rootB = find(y);

        if (rootA == rootB) {
            count++; 
            return;
        }
        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }

    int getCycle() {
        return count;
    }
    int getComponent() {
        int components = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                components++;
            }
        }
        return components;
    }
}

class Solution {
    public int makeConnected(int n, int[][] edges) {
        if (edges.length < n - 1) {
            return -1;
        }

        DSU ds = new DSU(n);
        for (int[] edge : edges) {
            ds.merge(edge[0], edge[1]);
        }
        int components = ds.getComponent();
        int redundantEdges = ds.getCycle();
        if (redundantEdges >= components - 1) {
            return components - 1;
        }
        return -1;
    }
}