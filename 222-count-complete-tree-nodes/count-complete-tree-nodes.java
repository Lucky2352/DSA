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
    public int leftHeight(TreeNode root){
        int height = 0;
        while(root != null){
            root = root.left;
            height++;
        }
        return height;
    }
    public int rightHeight(TreeNode root){
        int height = 0;
        while(root != null){
            root = root.right;
            height++;
        }
        return height;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = leftHeight(root);
        int right = rightHeight(root);

        if(left == right)return (int)(Math.pow(2,left) - 1);

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}