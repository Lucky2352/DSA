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
    public boolean dfs(TreeNode root,long min,long max){
        if(root == null)return true;

        if(root.val <= min || root.val >= max)return false;

        if(root.left != null){
            if(root.left.val >= root.val)return false;
            if(!dfs(root.left,min,root.val))return false;
        }
        if(root.right != null){
            if(root.right.val <= root.val)return false;
            if(!dfs(root.right,root.val,max))return false;
        }
        return true;
    }
    // public boolean isSorted(List<Integer> list){
    //     for(int i = 1;i<list.size();i++){
    //         if(list.get(i - 1) >= list.get(i))return false;
    //     }
    //     return true;
    // }
    // public void inorder(TreeNode root,List<Integer> list){
    //     if(root == null)return;
    //     inorder(root.left,list);
    //     list.add(root.val);
    //     inorder(root.right,list);
    // }
    public boolean isValidBST(TreeNode root) {
        // List<Integer> list = new ArrayList<>();
        // inorder(root,list);
        // return isSorted(list);
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}