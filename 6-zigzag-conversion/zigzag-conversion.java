class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows)return s;
        List<Character>[] list = new ArrayList[numRows];
        for(int k =0;k<numRows;k++){
            list[k] = new ArrayList<>();
        }
        int dir = 0;
        int i = 0;
        while(i<s.length()){
            if(dir % 2 == 0){
                int count = 0;
                int j = i;
                while(j < s.length() && count < numRows){
                    list[count].add(s.charAt(j));
                    count++;
                    j++;
                }
                i = j;
                dir++;
            }else{
                int count = numRows - 2;
                int j = i;
                while(j < s.length() && count > 0){
                    list[count].add(s.charAt(j));
                    count--;
                    j++;
                }
                i = j;
                dir++;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (List<Character> row : list) {
            for (char c : row)
                ans.append(c);
            }

        return ans.toString();
    }
}