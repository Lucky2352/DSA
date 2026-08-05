class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int n : arr1)
            count[n]++;
            int k = 0;
            for (int n : arr2)
            while (count[n]-- > 0)
                arr1[k++] = n;

        for (int i = 0; i < 1001; i++)
            while (count[i]-- > 0)
                arr1[k++] = i;

        return arr1;
    }
}
        
    