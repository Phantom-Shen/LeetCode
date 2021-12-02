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
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode odd, even;
        odd = head;
        even = head.next;
        
        ListNode curo = odd, cure = even, temp;
        while(curo.next!=null && curo.next.next!=null){
            //System.out.println(curo.val + ", " + cure.val);
            temp = curo;
            curo = curo.next.next;
            cure.next = curo.next;
            cure = cure.next;
            temp.next = curo;
        }
        curo.next = even;
        return odd;
    }
}
