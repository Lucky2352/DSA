class Solution {
    public int trap(int[] h) {
        int trapWater = 0;
        int i = 0;
        int j = h.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while(i <= j){
            leftMax = Math.max(h[i],leftMax);
            rightMax = Math.max(h[j],rightMax);
            if(leftMax < rightMax){
                trapWater += leftMax - h[i];
                i++;
            }else{
                trapWater += rightMax - h[j];
                j--;
            }
        }
        return trapWater;
    }
}