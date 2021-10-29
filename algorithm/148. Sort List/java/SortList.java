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
// get mid
// divide
// conquer
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(fast));
    }
    
    private ListNode merge(ListNode l, ListNode r){
        if(l==null) return r;
        if(r==null) return l;
        if(l.val < r.val){
            l.next = merge(l.next,r);
            return l;
        }
        r.next = merge(l,r.next);
        return r;
    }
}
