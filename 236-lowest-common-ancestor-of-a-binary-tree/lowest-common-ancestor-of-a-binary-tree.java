class Solution {
    List<TreeNode> path = new ArrayList<>();
    public void dfs(TreeNode root, TreeNode target, List<TreeNode> temp) {
        if (root == null) return;
        temp.add(root);
        if (root == target) {
            path = new ArrayList<>(temp);
            return;
        }
        dfs(root.left, target, temp);
        dfs(root.right, target, temp);
        temp.remove(temp.size() - 1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        dfs(root, p, pathP);
        pathP = path;
        path = new ArrayList<>();
        dfs(root, q, pathQ);
        pathQ = path;
        int i = 0;
        while (i < pathP.size() && i < pathQ.size() && pathP.get(i) == pathQ.get(i)) {
            i++;
        }
        return pathP.get(i - 1);
    }
}