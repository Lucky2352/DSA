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
    int cur = 0;
    public void traverse(TreeNode root){
        if(root == null)return;
        traverse(root.right);
        cur += root.val;
        if(root.val < cur){
            root.val  = cur;
        }
        traverse(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
}