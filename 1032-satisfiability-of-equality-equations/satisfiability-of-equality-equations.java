
class DSU {
    int[] parent;
    int[] size;
    int count = 0;

    public DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
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

    boolean merge(int x, int y) {
        int rootA = find(x);
        int rootB = find(y);

        if (rootA == rootB) return false;

        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];

        return true;
    }
}

class Solution {
    public boolean equationsPossible(String[] e) {
        DSU d = new DSU(25);

        for (int i = 0; i < e.length; i++) {
            String s = e[i];
            if (s.charAt(1) == '=') {
                d.merge(s.charAt(0) - 'a',s.charAt(3) - 'a');
            }
        }
        for (int i = 0; i < e.length; i++) {
            String s = e[i];
            if (s.charAt(1) == '!') {
                if (d.find(s.charAt(0) - 'a') == d.find(s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
