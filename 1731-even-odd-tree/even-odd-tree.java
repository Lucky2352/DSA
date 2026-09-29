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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = -1;
        while(!q.isEmpty()){
            int size = q.size();
            index++;
            List<Integer> list = new ArrayList<>();
            boolean flag = false;
            for(int i = 0;i < size;i++){
                TreeNode temp = q.poll();
                list.add(temp.val);
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            int cur = list.get(0);
            if(index % 2 == 0) {
                if(cur % 2 == 0) {
                    flag = true;
                }
            } else {
                if(cur % 2 == 1) {
                    flag = true;
                }
            }
            for(int i = 1;i<size;i++){
                if(index % 2 == 0){
                    if(list.get(i) % 2 == 0){
                        flag = true;
                    }
                    if(list.get(i) <= cur){
                        flag = true;
                    }else{
                        cur = list.get(i);
                    }

                }else{
                    if(list.get(i) % 2 == 1){
                        flag = true;
                    }
                    if(list.get(i) >= cur){
                        flag = true;
                    }else{
                        cur = list.get(i);
                    }
                }
            }
            if(flag)return false;
        }
        return true;
    }
}