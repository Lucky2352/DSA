class Solution {
    public TreeNode dfs(TreeNode root, TreeNode t1,TreeNode t2) {
        if (root == null) return null;
        if (root == t1){
            return root;
        }
        if (root == t2){
            return root;
        }
        TreeNode left = dfs(root.left, t1, t2);
        TreeNode right = dfs(root.right, t1, t2);
        if(left != null && right != null)return root;
        if(left != null){
            return left;
        }else{
            return right;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }
}