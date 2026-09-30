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
//     public TreeNode searchBST(TreeNode root, int val) {
//         if(root == null)return root;
//         if(root.val == val){
//             return root;
//         }
//         if(val < root.val){
//             return searchBST(root.left,val);
//         }else{
//             return searchBST(root.right,val);
//         }
//     }
    public TreeNode getMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;

        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        
        else if(root.val < key){
           root.right = deleteNode(root.right,key); 
        }
        else{
            if(root.left == null){
            return root.right;

            }
            else if(root.right == null){
            return root.left;
            }
            else{
            TreeNode min = getMin(root.right);
            min.left = root.left;
            return deleteNode(root.right,key);
        }
    } 
    return root;
}
}