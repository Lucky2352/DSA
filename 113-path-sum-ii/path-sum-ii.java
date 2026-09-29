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
    public void recursion(TreeNode root,List<Integer> list,List<List<Integer>> ans,int targetSum){
        if(root == null)return;
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                list.add(root.val);
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);

            }
            return;
        }
            list.add(root.val);
            recursion(root.left,list,ans,targetSum - root.val);
            recursion(root.right,list,ans,targetSum - root.val);
            list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        recursion(root,list,ans,targetSum);
        return ans;
    }
}