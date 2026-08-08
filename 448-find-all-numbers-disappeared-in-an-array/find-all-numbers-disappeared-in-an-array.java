class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            arr[index] = -Math.abs(arr[index]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}