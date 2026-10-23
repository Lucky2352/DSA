class dsu{
    int[] parent;
    int[] size;
    int count = 0;
    public dsu(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 0;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    void merge(int x,int y){
        int rootA = find(x);
        int rootB = find(y);
        if(rootA == rootB)return;
        count++;

        if(rootA < rootB){
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }
    int getCount(){
        return count;
    }
}
class Solution {
    public int findCircleNum(int[][] ed) {
        // int n = ed.length;
        // boolean[] visited = new boolean[n];
        // Queue<Integer> q = new LinkedList<>();
        // int count = 0;
        // for (int i = 0; i < n; i++) {
        //     if (!visited[i]) {
        //         visited[i] = true;
        //         q.offer(i);
        //         count++;
        //         while (!q.isEmpty()) {
        //             int temp = q.poll();
        //             for (int j = 0; j < n; j++) {
        //                 if (ed[temp][j] == 1 && !visited[j]) {
        //                     visited[j] = true;
        //                     q.offer(j);
        //                 }
        //             }
        //         }
        //     }
        // }
        // return count;
        dsu helper = new dsu(ed.length);
        for(int i = 0;i<ed.length;i++){
            for(int j = i+1;j<ed[0].length;j++){
                if(ed[i][j] == 1){
                    helper.merge(i+1,j+1);
                }
            }
        }
        return ed.length - helper.getCount();
    }
}
