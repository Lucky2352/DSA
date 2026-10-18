class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int i = 0, j = 0;
        int right = 0, left = 0, up = 0, down = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        while (list.size() < m * n) {

            while (j < n - right && list.size() < m * n) {
                list.add(matrix[i][j]);
                j++;
            }
            right++;
            j--;
            i++;

            while (i < m - down && list.size() < m * n) {
                list.add(matrix[i][j]);
                i++;
            }
            down++;
            i--;
            j--;

            while (j >= left && list.size() < m * n) {
                list.add(matrix[i][j]);
                j--;
            }
            left++;
            j++;
            i--;

            while (i > up && list.size() < m * n) {
                list.add(matrix[i][j]);
                i--;
            }
            up++;
            i++;
            j++;
        }

        return list;
    }
}