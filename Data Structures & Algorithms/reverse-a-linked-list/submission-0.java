/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *  () ->  () -> ()
 *.   
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var inverted = head;
        var next = head.next;
        head.next = null;

        while (next != null) {
            var newNext = next.next;
            next.next = inverted;
            inverted = next;
            next = newNext;
        }

        return inverted;
    }
}
