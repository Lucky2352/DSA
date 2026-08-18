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

    public long sumSubarrayMins(int[] arr) {
        long ans = 0;
        int[] nse = new int[arr.length];
        int[] psee = new int[arr.length];
        NSE(arr, nse);
        PSEE(arr, psee);
        for(int i = 0; i < arr.length; i++){
            long cur = i - psee[i];
            long cur2 = nse[i] - i;
            ans += (long)arr[i] * cur * cur2;
        }
        return ans;
    }
    public static void NGE(int[] arr, int[] nge){
        Stack<Integer> st = new Stack<>();
        nge[arr.length - 1] = arr.length;
        st.push(arr.length - 1);
        for(int i = arr.length - 2; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = arr.length;
            }else{ 
                nge[i] = st.peek();
            }
            st.push(i);
        }
    }

    public static void PGEE(int[] arr, int[] pgee){
        Stack<Integer> st = new Stack<>();
        pgee[0] = -1;
        st.push(0);
        for(int i = 1; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pgee[i] = -1;
            }else{ 
                pgee[i] = st.peek();
            }
            st.push(i);
        }
    }

    public long sumSubarrayMaxs(int[] arr) {
        long ans = 0;

        int[] nge = new int[arr.length];
        int[] pgee = new int[arr.length];
        NGE(arr, nge);
        PGEE(arr, pgee);
        for(int i = 0; i < arr.length; i++){
            long cur = i - pgee[i];
            long cur2 = nge[i] - i;

            ans += (long)arr[i] * cur * cur2;
        }
        return ans;
    }

    public long subArrayRanges(int[] nums) {
        long mini = sumSubarrayMins(nums);
        long maxi = sumSubarrayMaxs(nums);
        return maxi - mini;
    }
}