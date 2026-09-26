class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int count = 0;
        for(int i = 0;i < intervals.length - 1;i++){
            int mini = intervals[i][0];
            int maxi = intervals[i][1];
            for(int j = i + 1;j < intervals.length;j++){
                if(mini <= intervals[j][1] && intervals[j][0] <= maxi) count++;
            }
        }
        return count;
    }
}