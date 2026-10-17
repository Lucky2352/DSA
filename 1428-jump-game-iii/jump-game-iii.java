class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean visited[] = new boolean[arr.length];
        while(!q.isEmpty()){
            int temp = q.poll();
            if(visited[temp])continue;
            visited[temp] = true;
            if(arr[temp] == 0)return true;
            if(temp + arr[temp] < arr.length)q.offer(temp + arr[temp]);
            if(temp - arr[temp] >= 0)q.offer(temp - arr[temp]);
        }
        return false;
    }
}