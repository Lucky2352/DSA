class Solution {
    Map<Integer, List<int[]>> map = new TreeMap<>();
    public void check(TreeNode root, int row, int col) {
        if (root == null) return;
        if (!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
        }
        map.get(col).add(new int[]{row, root.val});
        check(root.left, row + 1, col - 1);
        check(root.right, row + 1, col + 1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        check(root, 0, 0);
        for (List<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
              List<Integer> temp = new ArrayList<>();
            for (int[] arr : list) {
                temp.add(arr[1]);
            }
            ans.add(temp);
        }
        return ans;
    }
}