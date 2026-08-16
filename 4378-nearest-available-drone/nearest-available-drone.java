class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int tx = target[0];
        int ty = target[1];
        int mini = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0;i<drones.length;i++){
            int cal = Math.abs(drones[i][0] - tx) + Math.abs(drones[i][1] - ty);
            if(cal <= drones[i][2]){
                if(cal < mini){
                    mini = cal;
                    ans = i;
                }
            }
        }
        return ans;
    }
}