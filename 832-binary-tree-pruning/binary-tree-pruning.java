/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int right = dfs(root.right);
        int left = dfs(root.left);
        if (right == 0) root.right = null;
        if (left == 0) root.left = null;
        if (root.val == 1) return 1;
        if (right == 1 || left == 1) return 1;
        return 0;
    }

    public TreeNode pruneTree(TreeNode root) {
        if (dfs(root) == 0) return null;
        return root;
    }
}
