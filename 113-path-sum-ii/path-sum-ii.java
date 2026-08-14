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
    public static void recursion(TreeNode root, int targetSum,List<Integer> list,List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val){
            ans.add(new ArrayList<>(list));
        }
        recursion(root.left, targetSum - root.val, list, ans);
        recursion(root.right, targetSum - root.val, list, ans);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recursion(root, targetSum, list, ans);
        return ans;
    }
}