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
    int maxi = Integer.MAX_VALUE;
    TreeNode prev = null;
    public void findMax(TreeNode root){
        if(root == null)return;
        // if(root.right != null){
        //     maxi = Math.min(maxi,Math.abs(root.val - root.right.val));
        // }
        // if(root.left != null){
        //     maxi = Math.min(maxi,Math.abs(root.val - root.left.val));
        // }
        
        findMax(root.left);
        if(prev != null){
            maxi = Math.min(maxi,Math.abs(prev.val - root.val));
        }
        prev = root;
        findMax(root.right);  
    }
    public int getMinimumDifference(TreeNode root) {
        findMax(root);
        return maxi;
    }   
}