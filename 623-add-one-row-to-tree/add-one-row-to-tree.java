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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode nv = new TreeNode(val);
            nv.left = root;
            return nv;
        }
        int d = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            d++;
            if(d == depth - 1){
                for(int i = 0; i < size; i++){
                    TreeNode temp = q.poll();

                    TreeNode left = temp.left;
                    TreeNode right = temp.right;

                    TreeNode nv1 = new TreeNode(val);
                    TreeNode nv2 = new TreeNode(val);

                    temp.left = nv1;
                    temp.right = nv2;

                    nv1.left = left;
                    nv2.right = right;
                }
                break;
            }
            else{
                for(int i = 0; i < size; i++){
                    TreeNode temp = q.poll();

                    if(temp.left != null){
                        q.offer(temp.left);
                    }

                    if(temp.right != null){
                        q.offer(temp.right);
                    }
                }
            }
        }
        return root;
    }
}