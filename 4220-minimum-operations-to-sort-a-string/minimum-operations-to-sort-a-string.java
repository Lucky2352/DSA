class Solution {
    public int minOperations(String s) {
        boolean sort = false;
        for(int i = 0;i<s.length() - 1;i++){
            if(s.charAt(i) > s.charAt(i +1)){
                sort = true;
                break;
            }
        }
        if(!sort){
            return 0;
        }
        if(s.length() == 2 && sort)return -1;
        char mini = s.charAt(0);
        char maxi = s.charAt(s.length() - 1);
        boolean flag = false;
        boolean flag2 = false;
        for(int i = 1;i<s.length() - 1;i++){
            if(s.charAt(i) < mini){
                flag = true;
            }
            if(s.charAt(i) > maxi){
                flag2 = true;
            }
        }
        if(mini > maxi)flag = true;
        if(maxi < mini)flag2 = true;
        if(!flag || !flag2){
            return 1;
        }
        char big = s.charAt(0);
        int i1 = 0;
        char small = s.charAt(0);
        int i2 = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) > big){
                big = s.charAt(i);
                i1 = i;
            }
            if(s.charAt(i) < small){
                small = s.charAt(i);
                i2 = i;
            }
        }
        for(int i = 1;i<s.length() - 1;i++){
            if(s.charAt(i) == small || s.charAt(i) == big)return 2;
        }
        if(i1 == 0 && i2 == s.length() - 1)return 3;
        if(flag && flag2)return 2;
        return 3;
    }
}