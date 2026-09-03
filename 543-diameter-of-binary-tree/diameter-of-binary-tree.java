class Solution {
    int maxi = 0;
    public int check(TreeNode root){
        if(root == null) return 0;
        int left = check(root.left);
        int right = check(root.right);
        maxi = Math.max(maxi,left + right);
        return 1 + Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        check(root);
        return maxi;
    }
}