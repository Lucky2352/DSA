class Solution {
    public static boolean isPalindrome(String s,int st,int end){
        while(st < end){
            if(s.charAt(st) != s.charAt(end))return false;
            st++;
            end--;
        }
        return true;
    }
    public static void recursion(int index,String s,List<String> list,List<List<String>> ans){
        if(index >= s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                list.add(s.substring(index,i+1));
                recursion(i + 1,s,list,ans);
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        recursion(0,s,list,ans);
        return ans;
    }
}