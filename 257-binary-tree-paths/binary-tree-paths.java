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
    public void dfs(TreeNode root, StringBuilder s, List<String> list){
        if(root == null) return;
        int len = s.length();
        s.append(root.val).append("->");
        if(root.left == null && root.right == null){
            s.delete(s.length() - 2, s.length());
            list.add(s.toString());
            s.setLength(len);
            return;
        }

        dfs(root.left, s, list);
        dfs(root.right, s, list);

        s.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, new StringBuilder(), list);
        return list;
    }
}