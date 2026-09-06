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
    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> p = new LinkedList<>();
        q.offer(t1);
        p.offer(t2);
        while (!q.isEmpty() && !p.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp1 = q.poll();
                TreeNode temp2 = p.poll();
                if (temp1.val != temp2.val) return false;
                if (temp1.left == null && temp2.left != null) return false;
                if (temp1.left != null && temp2.left == null) return false;
                if (temp1.right == null && temp2.right != null) return false;
                if (temp1.right != null && temp2.right == null) return false;
                if (temp1.left != null) {
                    q.offer(temp1.left);
                    p.offer(temp2.left);
                }
                if (temp1.right != null) {
                    q.offer(temp1.right);
                    p.offer(temp2.right);
                }
            }
        }
        return q.isEmpty() && p.isEmpty();
    }
}