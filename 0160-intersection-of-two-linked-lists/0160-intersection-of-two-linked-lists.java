/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode  tempA = headA;
        ListNode tempB = headB;
        int m = 0;
        while(tempA!=null){
            m++;
            tempA= tempA.next;
        }
        int n =0;
        while(tempB!=null){
            n++;
            tempB = tempB.next;
        }
        ListNode skipA= headA;
        ListNode skipB = headB;
        if(m>n){
            for(int i=0;i<m-n;i++){
                skipA = skipA.next;
            }
        }
        else{
            for(int i=0;i<n-m;i++){
                skipB = skipB.next;
            }
        }
        while(skipA!=skipB){
            skipA = skipA.next;
            skipB = skipB.next;
        }
        return skipA;
    }
}