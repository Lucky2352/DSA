class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] arr = new int[seq.length()];
        int count = 0;
        for(int i = 0;i < seq.length();i++){
            if(seq.charAt(i) == '('){
                count++;
                arr[i] = count % 2;
            }else{
                arr[i] = count % 2;
                count--;
            }
        }
        return arr;
    }
}