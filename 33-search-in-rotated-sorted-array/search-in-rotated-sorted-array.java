class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int index = low + (high - low)/2;
			if(arr[index] == target) {
				return index;
			}
			if(arr[low] <= arr[index]) {
				if(arr[low] <= target && arr[index] >= target) {
					high = index;
				}else {
					low = index + 1;
				}
			}else {
				if(arr[index]<=target && arr[high]>=target) {
					low = index;
				}else {
					high = index - 1;
				}
			}
        }
        return -1;
    }
}