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
    public boolean traverse(TreeNode root,int sum,int k){
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum + root.val == k;
        }
        boolean left = traverse(root.left,sum + root.val,k);
        boolean right = traverse(root.right,sum + root.val,k);
        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return traverse(root,0,targetSum);
    }
}