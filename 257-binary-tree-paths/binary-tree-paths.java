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
    public void dfs(TreeNode root,String s,List<String> list){
        if(root == null)return;
        s = s + Integer.toString(root.val) + "->";
        if(root.left == null && root.right == null){
            list.add(s.substring(0,s.length() - 2));
            return;
        }
        dfs(root.left,s,list);
        dfs(root.right,s,list);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root,"",list);
        return list;
    }
}