class TreeAncestor {
    List<List<Integer>> up;
    public TreeAncestor(int n, int[] parent) {
        up = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            up.add(new ArrayList<>());

            for (int j = 0; j < 20; j++) {
                up.get(i).add(-1);
            }
        }
        for (int node = 0; node < n; node++) {
            up.get(node).set(0, parent[node]);
        }
        for (int j = 1; j < 20; j++) {
            for (int node = 0; node < n; node++) {
                int a = up.get(node).get(j - 1);
                if (a != -1) {
                    int b = up.get(a).get(j - 1);
                    up.get(node).set(j, b);
                }
            }
        }
    }
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < 20; j++) {
            if ((k & (1 << j)) != 0) {
                node = up.get(node).get(j);
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}