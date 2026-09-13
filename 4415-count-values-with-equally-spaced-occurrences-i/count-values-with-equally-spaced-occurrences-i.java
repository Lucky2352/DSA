class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> temp = map.get(nums[i]);
                temp.add(i);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i], temp);
            }
        }
        int count = 0;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.size() != 3) continue;
            if(list.get(1) - list.get(0) == 
               list.get(2) - list.get(1)){
                count++;
            }
        }
        return count;
    }
}