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
    int count = 0;
    public void dfs(TreeNode root,int cur){
        if(root == null)return;
        if(root.val >= cur){
            count++;
        }
        cur = Math.max(cur,root.val);
        dfs(root.left,cur);
        dfs(root.right,cur);
    }
    public int goodNodes(TreeNode root) {
        if(root == null)return 0;
        count = 0;
        dfs(root,root.val);
        return count;
    }
}