class StockSpanner {
    List<Integer> list;
    Stack<Integer> stack;
    public StockSpanner() {
        list = new ArrayList<>();
        stack = new Stack<>();
    }
    public int next(int price) {
        list.add(price);
        int i = list.size() - 1;
        while(!stack.isEmpty() && list.get(stack.peek()) <= price){
            stack.pop();
        }
        if(stack.isEmpty()){
            stack.push(i);
            return i + 1;
        }else{
            int ans = i - stack.peek();
            stack.push(i);
            return ans;
        }
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */