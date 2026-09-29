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
    public int check(TreeNode root,int arr[]){
        if(root == null)return -1;
        int left = check(root.left,arr);
        if(left != -1)return left;
        arr[0]--;
        if(arr[0] == 0)return root.val;
        return check(root.right,arr);
    }
    public int kthSmallest(TreeNode root, int k) {
        int arr[] = new int[1];
        arr[0] = k;
        return check(root,arr);
    }
}