class Solution {
    public static void dfs(int node,boolean visited[],ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(int val : adj.get(node)){
            if(!visited[val]){
                dfs(val,visited,adj);
            }
        }
    }
    public int findCircleNum(int[][] matrix) {
        int n = matrix.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        int len = adj.size();
        int count = 0;
        boolean visited[] = new boolean[len+1];
        for(int i = 0;i<len;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,adj);
            }       
        }
        return count;
    }
}