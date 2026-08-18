class Solution {
    public static void findNSE(int[] arr, List<Integer> list) {
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                list.add(arr.length);
            } else {
                list.add(st.peek());
            }
            st.push(i);
        }
        Collections.reverse(list);
    }
    public static void findPSEE(int[] arr, List<Integer> list) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                list.add(-1);
            } else {
                list.add(st.peek());
            }
            st.push(i);
        }
    }

    public int sumSubarrayMins(int[] arr) {
        long mod = 1000000007;
        long total = 0;

        List<Integer> NSE = new ArrayList<>();
        List<Integer> PSEE = new ArrayList<>();

        findNSE(arr, NSE);
        findPSEE(arr, PSEE);

        for (int i = 0; i < arr.length; i++) {
            long left = i - PSEE.get(i);
            long right = NSE.get(i) - i;

            total = (total + (long) arr[i] * left * right) % mod;
        }
        return (int) total;
    }
}