
class Solution {
    public int findCircleNum(int[][] ed) {
        int n = ed.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                q.offer(i);
                count++;
                while (!q.isEmpty()) {
                    int temp = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (ed[temp][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}
