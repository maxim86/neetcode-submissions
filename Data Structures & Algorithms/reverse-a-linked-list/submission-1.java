/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *  1 -> 2 -> 3
 *  1    2 <- 3 
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        var newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
