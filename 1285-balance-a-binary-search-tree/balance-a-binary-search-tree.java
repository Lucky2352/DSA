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
    public static void traverse(TreeNode root, List<Integer> list){
        if(root == null)return;
        traverse(root.left,list);
        list.add(root.val);
        traverse(root.right,list);
    }
    public TreeNode create(List<Integer> list,int low,int high){
        if(low > high)return null;
        int mid = low + (high - low)/2;
        TreeNode nv = new TreeNode(list.get(mid));
        nv.left = create(list,low,mid - 1);
        nv.right = create(list,mid + 1,high);
        return nv;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        return create(list,0,list.size() - 1);
    }
}