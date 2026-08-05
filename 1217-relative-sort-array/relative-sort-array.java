class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int p = 0;
        int q = 0;
        while (p < arr2.length) {
            int count = map.get(arr2[p]);

            while (count-- > 0) {
                arr1[q++] = arr2[p];
            }
            map.remove(arr2[p]);
            p++;
        }
        for (int val : map.keySet()) {
            int count = map.get(val);

            while (count-- > 0) {
                arr1[q++] = val;
            }
        }
        return arr1;
    }
}