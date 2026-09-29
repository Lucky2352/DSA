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
    public int maxLevelSum(TreeNode root) {
        int maximum = Integer.MIN_VALUE;
        int ans = -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 0;
        while(!q.isEmpty()){
            int size = q.size();
            index++;
            int maxi = 0;
            for(int i = 0;i < size;i++){
                TreeNode temp = q.poll();
                maxi += temp.val;
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            if(maxi > maximum){
                ans = index;
                maximum = maxi;
            }
        }
        return ans;
    }
}