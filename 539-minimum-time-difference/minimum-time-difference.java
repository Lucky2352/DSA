class Solution {
    public int findMinDifference(List<String> tm) {
        boolean[] arr = new boolean[1440];
        for (String s : tm) {
            int hour = Integer.parseInt(s.substring(0, 2));
            int min = Integer.parseInt(s.substring(3, 5));
            int time = hour * 60 + min;
            if (arr[time]) {
                return 0;
            }
            arr[time] = true;
        }
        int cur = -1;
        int prev = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0;i < 1440;i++) {
            if (arr[i]) {
                if (cur == -1) {
                    cur = i;
                }
                if (prev != -1) {
                    ans = Math.min(ans, i - prev);
                }
                prev = i;
            }
        }
        ans = Math.min(ans,1440 - prev + cur);
        return ans;
    }
}