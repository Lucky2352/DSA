class Solution {
    public String evaluate(String s, List<List<String>> kn) {
        Map<String,String> map = new HashMap<>();

        for(int m = 0;m < kn.size();m++){
            map.put(kn.get(m).get(0),kn.get(m).get(1));
        }

        StringBuilder sb = new StringBuilder("");

        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '('){
                int j = i + 1;
                StringBuilder temp = new StringBuilder();
                while(j < s.length() && s.charAt(j) != ')'){
                    temp.append(s.charAt(j));
                    j++;
                }
                sb.append(map.getOrDefault(temp.toString(), "?"));
                i = j + 1;
            }else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}