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
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null && root.right == null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = q.poll();
                int val = temp.val;
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
                if(val % 2 == 0){
                    if(temp.left != null){
                        
                        if(temp.left.left != null){
                            sum += temp.left.left.val;
                        }
                        if(temp.left.right != null){
                            sum += temp.left.right.val;
                        }
                    }
                    if(temp.right != null){
                        if(temp.right.left != null){
                            sum += temp.right.left.val;
                        }
                        if(temp.right.right != null){
                            sum += temp.right.right.val;
                        }
                    }
                }
            }
        }
        return sum;
    }
}