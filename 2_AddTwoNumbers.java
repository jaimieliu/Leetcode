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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ones = 0;
        int sum = 0;
        ListNode out = new ListNode();
        ListNode orig = new ListNode();
        orig = out;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null || cur2 != null || ones != 0 ){
            sum = 0;
            ListNode next = new ListNode();
            if(cur1 != null){
                sum += cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                sum += cur2.val;
                cur2 = cur2.next;
            }
            sum += ones;
            next.val = (sum % 10);
            ones = sum/10;
        
            out.next = next;
            out = out.next;
        }
        
        return orig.next;
    }
}