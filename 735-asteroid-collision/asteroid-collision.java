class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> st = new Stack<>();
        st.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= 0) {
                st.push(a[i]);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(a[i])) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(a[i])) {
                    st.pop();
                } 
                else if (st.isEmpty() || st.peek() < 0) {
                    st.push(a[i]);
                }
            }
        }
        int ans[] = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}