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
    public static void newTree(TreeNode root,int val,TreeNode parent,boolean flag){
        if(root == null){
            if(flag){
                parent.left = new TreeNode(val);
            }else{
                parent.right = new TreeNode(val);
            }
            return;
        }
        if(root.val > val) newTree(root.left, val,root,true);
        else newTree(root.right, val,root,false);

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // if(root == null) return new TreeNode(val);
        // if(root.val > val) root.left = insertIntoBST(root.left, val);
        // else root.right = insertIntoBST(root.right, val);
        // return root;
        if(root == null)return new TreeNode(val);
        newTree(root,val,root,true);
        return root;
    }
}