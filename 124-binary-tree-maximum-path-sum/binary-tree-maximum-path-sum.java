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
    int maxi = Integer.MIN_VALUE;
    public int pathS(TreeNode root){
        if(root == null)return 0;
        int left = Math.max(0,pathS(root.left));
        int right =  Math.max(0,pathS(root.right));
        maxi = Math.max(maxi,Math.max(root.val + left + right,root.val));
        return root.val + Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        pathS(root);
        return maxi;
    }
}