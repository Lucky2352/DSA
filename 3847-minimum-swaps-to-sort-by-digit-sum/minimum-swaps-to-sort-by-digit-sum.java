class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int sum = 0;

            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;

            map.put(nums[i], new int[]{i, -1});
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        //mapping the values to its cuurent index and expected index
        for (int i = 0; i < n; i++) {
            map.get(arr[i][0])[1] = i;
        }
        //visited array to have a track for cycle
        boolean[] visited = new boolean[n];
        //total swaps
        int swaps = 0;
        //intution is something like nums = [4, 3, 2, 1] ==>[1, 2, 3, 4]
        //element curindex expectedindex
        //4	0 3
        //3	1 2
        //2	2 1
        //1	3 0

        //cycle detection hance always we need cycle - 1 swaps
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int j = i;
            int cycleSize = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j])[1];
                cycleSize++;
            }
            swaps += Math.max(0, cycleSize - 1);
        }
        return swaps;
    }
}