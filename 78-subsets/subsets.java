class Solution {
    public List<List<Integer>> list2 = new ArrayList<>();
  public void recursion2(List<Integer> vals, int arr[],int i){
      if(i == arr.length){
        list2.add(new ArrayList<>(vals));
        return;
      }
      vals.add(arr[i]);
      recursion2(vals,arr,i + 1);
      vals.remove(vals.size() - 1);
      recursion2(vals,arr,i+1);
  }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> vals = new ArrayList<>();
        recursion2(vals,nums,0);
        return list2;
    }
}