class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int ans = Integer.MIN_VALUE;
        for(int i = 1;i<h.length;i++){
            if(st.isEmpty()){
                st.push(i);
            }
            else if(h[st.peek()] <= h[i]){
                st.push(i);
            }else{
    while(!st.isEmpty() && h[st.peek()] > h[i]){
        int temp = st.pop();

        int width;
        if(st.isEmpty()){
            width = i;
        }else{
            width = i - st.peek() - 1;
        }
        ans = Math.max(ans, width * h[temp]);
        }

        st.push(i);
            }
    }
        while(!st.isEmpty()){
    int temp = st.pop();

    int width;
    if(st.isEmpty())
        width = h.length;
    else
        width = h.length - st.peek() - 1;

    ans = Math.max(ans, width * h[temp]);
}
        return ans;
    }
}