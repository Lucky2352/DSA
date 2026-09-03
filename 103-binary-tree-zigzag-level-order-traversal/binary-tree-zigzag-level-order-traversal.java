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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)return ans;
        q.offer(root);
        int flag = 0;
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int sz = q.size();
            for(int i = 0;i<sz;i++){
                if(q.peek().left!=null)q.offer(q.peek().left);
                if(q.peek().right != null)q.offer(q.peek().right);
                list.add(q.poll().val);
            }
            if(flag == 0){
                ans.add(new ArrayList<>(list));
                flag = 1;
            }else{
                Collections.reverse(list);
                ans.add(new ArrayList<>(list));
                flag = 0;
            }   
            
        }
        return ans;
    }
}