class Solution {
    public boolean sumGame(String num) {
        int s1 = 0;
        int c1 = 0;
        for(int i = 0;i<num.length()/2;i++){
            if(num.charAt(i) == '?'){
                c1++;
            }else{
                s1 += num.charAt(i) - '0';
            }
        }
        int s2 = 0;
        int c2 = 0;
        for(int i = num.length()/2;i<num.length();i++){
            if(num.charAt(i) == '?'){
                c2++;
            }else{
                s2 += num.charAt(i) - '0';
            }
        }
        if(c1 == 0 && c2 == 0){
            return s1 != s2;
        }
        int valueNeed = s1 - s2;
        int possibleValue = c1 - c2;
        if (possibleValue == 0) {
            return valueNeed != 0;
        }
        return 2 * valueNeed != -9 * possibleValue;
    }
}