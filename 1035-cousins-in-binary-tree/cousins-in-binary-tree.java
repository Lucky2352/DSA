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
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public void parent(TreeNode root) {
        if(root == null) return;
        if(root.left != null) {
            map.put(root.left, root);
        }
        if(root.right != null) {
            map.put(root.right, root);
        }
        parent(root.left);
        parent(root.right);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        parent(root);
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode nodeX = null;
            TreeNode nodeY = null;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.val == x) {
                    nodeX = node;
                }
                if(node.val == y) {
                    nodeY = node;
                }
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            if(nodeX != null && nodeY != null) {
                return map.get(nodeX) != map.get(nodeY);
            }
            if(nodeX != null || nodeY != null) {
                return false;
            }
        }
        return false;
    }
}