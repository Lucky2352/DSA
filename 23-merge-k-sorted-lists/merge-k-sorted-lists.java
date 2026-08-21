/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<lists.length;i++){
            ListNode t1 = lists[i];
            while(t1 != null){
                list.add(t1.val);
                t1 = t1.next;
            }
        }
        Collections.sort(list);
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for(int i = 0;i<list.size();i++){
            ListNode nv = new ListNode(list.get(i));
            temp.next = nv;
            temp = temp.next;
        }
        return dummy.next;
    }
}