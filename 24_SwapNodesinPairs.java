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
    // node1s next = node 2s next
    //node 2s next = node1
    //current is node1's next
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;
        if(head.next != null){
            ListNode temp = new ListNode();
            temp = head;
            head = head.next;
            helper(temp, null);
        }

        return head;
    }
    
    public void helper(ListNode head, ListNode prevHead){
        if(head.next != null){
            ListNode node2 = head.next;
            head.next = node2.next;
            node2.next = head;
            if(prevHead != null)
                prevHead.next = node2;
            prevHead = head;
            if(head.next != null)
                helper(head.next, prevHead);
        }
    }
}