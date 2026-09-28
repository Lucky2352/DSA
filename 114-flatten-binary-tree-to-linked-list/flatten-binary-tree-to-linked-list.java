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
    //brute force solution

    public void preorder(TreeNode root,List<Integer> list){
        if(root == null)return;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        List<Integer> list = new ArrayList<>();
        preorder(root, list);

        TreeNode curr = root;

        for(int i = 1; i < list.size(); i++) {
            curr.left = null;
            curr.right = new TreeNode(list.get(i));
            curr = curr.right;
        }

        curr.left = null;
        curr.right = null;

    }
}