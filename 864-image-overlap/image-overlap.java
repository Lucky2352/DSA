class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int ans = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<img1.length;i++){
            for(int j=0;j<img2.length;j++){
                if(img1[i][j]==1){
                    for(int p=0;p<img2.length;p++){
                        for(int q=0;q<img2.length;q++){
                            if (img2[p][q] == 1) {
                                int dr = p - i;
                                int dc = q - j;
                                String key = dr + "," + dc;
                                map.put(key, map.getOrDefault(key, 0) + 1);
                                ans = Math.max(ans, map.get(key));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}