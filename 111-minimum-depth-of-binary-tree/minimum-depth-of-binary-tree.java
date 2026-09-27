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
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        int ans = 0;
        if(left==0)ans = right + 1;
        else if(right==0)ans = left + 1;
        else{
            ans = Math.min(left,right) + 1;
        }
        return ans;
    }
}