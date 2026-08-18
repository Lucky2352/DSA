class Solution {
    public static void NSE(int[] arr,List<Integer> list){
        Stack<Integer> st = new Stack<>();
        list.add(arr.length);
        st.push(arr.length - 1);
        for(int i = arr.length - 2;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                list.add(arr.length);
            }else{ 
                list.add(st.peek());
            }
            st.push(i);
        }
        Collections.reverse(list);
    }
    public static void PSEE(int[] arr,List<Integer> list){
        Stack<Integer> st = new Stack<>();
        list.add(-1);
        st.push(0);
        for(int i = 1;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                list.add(-1);
            }else{ 
                list.add(st.peek());
            }
            st.push(i);
        }
    }
    public int sumSubarrayMins(int[] arr) {
        long mod = 1000000007;
        long ans = 0;
        List<Integer> nse = new ArrayList<>();
        List<Integer> psee = new ArrayList<>();
        NSE(arr,nse);
        PSEE(arr,psee);
        for(int i = 0;i<arr.length;i++){
            long cur = i - psee.get(i);
            long cur2 = nse.get(i) - i;
            ans = (int)(ans + ((long)arr[i] * (cur * cur2) % mod)) % mod;
        }
        return (int)ans;
    }
}