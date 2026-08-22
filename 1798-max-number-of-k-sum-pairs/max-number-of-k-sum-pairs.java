class Solution {
    public int maxOperations(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(k - arr[i])){
                count++;
                map.put(k - arr[i],map.getOrDefault(k - arr[i],0)-1);
                if(map.get(k - arr[i]) == 0)map.remove(k - arr[i]);
            }else{
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
        }
        return count;
    }
}