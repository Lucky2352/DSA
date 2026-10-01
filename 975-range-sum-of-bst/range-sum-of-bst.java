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
    int sum = 0;
    public void traverse(TreeNode root,int left,int right){
        if(root == null)return;
            if(root.val >= left && root.val <= right){
                sum += root.val;
                traverse(root.left,left,right);
                traverse(root.right,left,right);
            }
            if(root.val < left){
                traverse(root.right,left,right);
            }
            if(root.val > right){
                traverse(root.left,left,right);
            }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root,low,high);
        return sum;
    }
}