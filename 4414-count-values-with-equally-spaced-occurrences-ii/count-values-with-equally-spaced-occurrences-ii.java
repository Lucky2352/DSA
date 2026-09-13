class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
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
            if(list.size() < 3) continue;
            boolean flag = true;
            for(int i = 0;i < list.size() - 2;i++){
                if(list.get(i + 1) - list.get(i) != list.get(i + 2) - list.get(i + 1)){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;
    }
}