class Solution {
    public int totalFruit(int[] f) {
        int i = 0;
        int j = 0;
        int maxi = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(j < f.length){
            map.put(f[j],map.getOrDefault(f[j],0)+1);
            j++;
            if(map.size() > 2){
                maxi = Math.max(maxi,j-i - 1);
                while(i < j && map.size() > 2){
                    map.put(f[i],map.getOrDefault(f[i],0)-1);
                    if(map.get(f[i]) == 0){
                        map.remove(f[i]);
                    }
                    i++;
                }
            }
            
        }
        maxi = Math.max(maxi,j-i);
        return maxi;
    }
}