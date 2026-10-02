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
    int total = 0;
    public void dfs(TreeNode root,int sum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum = (sum * 10) + root.val;
            total += sum;
            return;
        }
        dfs(root.left,(sum * 10)+root.val);
        dfs(root.right,(sum * 10)+root.val);
    }
    public int sumNumbers(TreeNode root) {
        if(root == null)return 0;
        dfs(root,0);
        return total;
    }
}