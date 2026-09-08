/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> map = new HashMap<>();
    public void dfs(TreeNode root){
        if(root == null)return;
        if(root.left != null){
            map.put(root.left,root);
        }
        if(root.right != null){
            map.put(root.right,root);
        }
        dfs(root.left);
        dfs(root.right);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        dfs(root);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k) {
                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }
                return ans;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }
                if (map.containsKey(node) && !visited.contains(map.get(node))) {
                    visited.add(map.get(node));
                    q.add(map.get(node));
                }
            }
            distance++;
        }
        return ans;
    }
}