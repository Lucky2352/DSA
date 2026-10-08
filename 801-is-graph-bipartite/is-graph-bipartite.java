class Solution {
    boolean flag = true;
    void dfs(int node,int[][] adj,int[] colour){

        for(int val : adj[node]){
            if(colour[val] == colour[node]){
                flag = false;
                return;
            }
            if(colour[val] == -1){
              colour[val] = 1 - colour[node];
              dfs(val,adj,colour);
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colour = new int[graph.length];
        Arrays.fill(colour,-1);
        for(int i = 0;i<n;i++){
            if(colour[i] == -1){
                colour[i] = 0;
                dfs(i,graph,colour);

                if(!flag)return false;
            }
        }
        return flag;
    }
}