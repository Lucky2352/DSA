class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    void dfs(int node,List<List<Integer>> adj,List<Integer> list){
        if(node == adj.size() - 1){
            list.add(node);
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        for(int val : adj.get(node)){
            list.add(node);
            dfs(val,adj,list);
            list.remove(list.size() - 1);
        }

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<graph.length;i++){
            for(int j = 0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        for(List<Integer> temp : adj){
            System.out.println(temp);
        }
        dfs(0,adj,new ArrayList<>());
        return ans;
    }
}