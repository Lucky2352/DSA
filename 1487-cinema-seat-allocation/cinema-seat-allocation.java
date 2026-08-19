class Solution {
    public int maxNumberOfFamilies(int n, int[][] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int r = nums[i][0] - 1;
            int c = nums[i][1] - 1;
            if (!map.containsKey(r)) {
                map.put(r, new int[10]);
            }
            map.get(r)[c] = 1;
        }
        int total = (n - map.size()) * 2;
        for (int[] row : map.values()) {
            int count = 0;
            for (int j = 1; j < 7; j += 2) {
                int k = j;
                while (k < j + 4) {
                    if (row[k] == 0) {
                        k++;
                    } else {
                        break;
                    }
                }
                if (k == j + 4) {
                    count++;
                }
            }
            if (count == 3) {
                total += 2;
            } else if (count > 0) {
                total += 1;
            }
        }
        return total;
    }
}