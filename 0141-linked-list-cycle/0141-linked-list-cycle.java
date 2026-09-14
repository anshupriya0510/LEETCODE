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
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode turtle = head;
        ListNode hare = head;
        while(hare !=null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
            if(turtle == hare){
                return true;
            }
        }
        return false;
        
    }
}