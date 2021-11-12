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
// Using a sentinel node would make this problem very easy, but it will detroy its adaptation to concurrency, since it changes the data.
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // remove nodes with value of val from the beginning
        while(head!=null&&head.val==val) head = head.next;
        // remove rest of the nodes that have value of val
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return head;
    }
}
