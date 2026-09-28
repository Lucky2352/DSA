/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
                    q.offer(dummy);
        }else{
        q.offer(root);

        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp.val == Integer.MAX_VALUE){
                    sb.append("#,");
                }else{
                    sb.append(Integer.toString(temp.val)).append(",");

                    if(temp.left == null){
                    TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
                    q.offer(dummy);
                }else{
                    q.offer(temp.left);
                }

                if(temp.right == null){
                    TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
                    q.offer(dummy);
                }else{
                    q.offer(temp.right);
                }
                }
                
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        if(arr[0].equals("#"))return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int l = 1;
        while(!q.isEmpty() && l < arr.length){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = q.poll();
                if(l < arr.length){
                    if(arr[l].equals("#")){
                    temp.left = null;
                    l++;
                }else{
                    TreeNode dummy = new TreeNode(Integer.parseInt(arr[l]));
                    temp.left = dummy;
                    q.offer(dummy);
                    l++;
                }
                }
                if(l < arr.length){
                    if(arr[l].equals("#")){
                    temp.right = null;
                    l++;
                }else{
                    TreeNode dummy = new TreeNode(Integer.parseInt(arr[l]));
                    temp.right = dummy;
                    q.offer(dummy);
                    l++;
                }
                }
                
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;