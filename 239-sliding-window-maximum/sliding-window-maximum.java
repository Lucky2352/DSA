class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            if(dq.isEmpty()){
                dq.offerLast(i);
            }else{
                while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                    dq.pollLast();
                }
                dq.offerLast(i);
            }
        }
        ans[0] = nums[dq.peekFirst()];
        int p = 1;
        for(int i = k; i < nums.length; i++){
            if(dq.isEmpty()){
                dq.offerLast(i);
            }else{
                while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                    dq.pollLast();
                }
                dq.offerLast(i);
            }
            if(dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            ans[p] = nums[dq.peekFirst()];
            p++;
        }
        return ans;
    }
}