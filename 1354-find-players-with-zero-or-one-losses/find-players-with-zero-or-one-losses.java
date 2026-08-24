class pair{
    int win;
    int loss;

    pair(int win,int loss){
        this.win = win;
        this.loss = loss;
    }
}
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,pair> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<matches.length;i++){
            if(map.containsKey(matches[i][0])){
                pair wtemp = map.get(matches[i][0]);
                int wwin = wtemp.win + 1;
                int wloss = wtemp.loss;
                map.put(matches[i][0],new pair(wwin,wloss));
            }
            if(map.containsKey(matches[i][1])){
                pair ltemp = map.get(matches[i][1]);
                int lloss = ltemp.loss + 1;
                int lwin = ltemp.win;
                map.put(matches[i][1],new pair(lwin,lloss));
            }
            if(!map.containsKey(matches[i][0])){
                map.put(matches[i][0],new pair(1,0));
            }
            if(!map.containsKey(matches[i][1])){
                map.put(matches[i][1],new pair(0,1));
            }
        }
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (Map.Entry<Integer, pair> entry : map.entrySet()) {
            int person = entry.getKey();
            pair temp = entry.getValue();
            int win = temp.win;
            int loss = temp.loss;
            if(loss == 0){
                l1.add(person);
            }
            if(loss == 1){
                l2.add(person);
            }
        }
        Collections.sort(l1);
        Collections.sort(l2);
        list.add(new ArrayList<>(l1));
        list.add(new ArrayList<>(l2));

        return list;
    }
}