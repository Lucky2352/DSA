class Solution {
    public static void NSE(int[] arr, int[] nse){
        Stack<Integer> st = new Stack<>();
        nse[arr.length - 1] = arr.length;
        st.push(arr.length - 1);

        for(int i = arr.length - 2; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i] = arr.length;
            }else{ 
                nse[i] = st.peek();
            }

            st.push(i);
        }
    }
    public static void PSEE(int[] arr, int[] psee){
        Stack<Integer> st = new Stack<>();
        psee[0] = -1;
        st.push(0);
        for(int i = 1; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                psee[i] = -1;
            }else{ 
                psee[i] = st.peek();
            }

            st.push(i);
        }
    }
    public int sumSubarrayMins(int[] arr) {
        long mod = 1000000007;
        long ans = 0;
        int[] nse = new int[arr.length];
        int[] psee = new int[arr.length];
        NSE(arr, nse);
        PSEE(arr, psee);
        for(int i = 0; i < arr.length; i++){
            long cur = i - psee[i];
            long cur2 = nse[i] - i;
            ans = (ans + ((long)arr[i] * (cur * cur2) % mod)) % mod;
        }
        return (int)ans;
    }
}