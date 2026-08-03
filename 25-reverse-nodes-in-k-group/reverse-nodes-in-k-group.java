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
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode front = null;
        ListNode temp = head;
        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (temp != null) {
            ListNode kthNode = temp;
            boolean flag = true;
            for (int i = 1; i < k; i++) {
                if (kthNode == null || kthNode.next == null) {
                    flag = false;
                    break;
                }
                kthNode = kthNode.next;
            }
            if (!flag) {
                prev.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            ListNode newHead = reverse(temp);
            prev.next = newHead;
            temp.next = nextNode;
            prev = temp;
            temp = nextNode;
        }
        return dummy.next;
    }
}