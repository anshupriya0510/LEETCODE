/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head;
        while(hare!=null&&hare.next!=null){
            hare = hare.next.next;
            turtle = turtle.next;
            if(turtle==hare){
                turtle=head;
                while (turtle!=hare)
            {
               turtle=turtle.next;
               hare=hare.next;
            }
            if (turtle==hare)
            {
                return hare;
            }
            }
            

        }
        return null;

    }
}