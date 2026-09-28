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

        if(root == null) {
            return "#";
        }

        q.offer(root);

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            TreeNode temp = q.poll();

            if(temp == null) {
                sb.append("#,");
            } else {
                sb.append(temp.val).append(",");

                q.offer(temp.left);
                q.offer(temp.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.equals("#")) {
            return null;
        }

        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int l = 1;

        while(!q.isEmpty()) {

            TreeNode temp = q.poll();

            if(!arr[l].equals("#")) {
                temp.left = new TreeNode(Integer.parseInt(arr[l]));
                q.offer(temp.left);
            }

            l++;

            if(!arr[l].equals("#")) {
                temp.right = new TreeNode(Integer.parseInt(arr[l]));
                q.offer(temp.right);
            }

            l++;
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