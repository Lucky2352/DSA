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
    public static boolean sort(List<Integer> list){
        for(int i = 1;i<list.size();i++){
            if(list.get(i - 1) >= list.get(i))return false;
        }
        return true;
    }
    public static void traverse(TreeNode root,List<Integer> list){
        if(root == null)return;
        traverse(root.left,list);
        list.add(root.val);
        traverse(root.right,list);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        return sort(list);
    }
}