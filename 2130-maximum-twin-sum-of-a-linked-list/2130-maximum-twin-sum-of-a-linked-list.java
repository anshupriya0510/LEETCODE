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
        
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = null;
        ListNode c = head;
        while (c != slow) {
            ListNode t = c.next;
            c.next = mid;
            mid = c;
            c = t;
        }
        int ans = 0;
        while (slow != null) {
            ans = Math.max(ans, slow.val + mid.val);
            slow = slow.next;
            mid = mid.next;
        }
        return ans;
    }
}