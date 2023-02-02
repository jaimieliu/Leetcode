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

 // Option 1: add to list and go from there - slow, but easier
 // Option 2: work with nodes - optimized


 // First Run: Time Limit Exceeded - k % number of nodes
 
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int numNodes = findNumNodes(head);

        int iter = k % numNodes;

        for(int i = 0; i < iter; i++){
            ListNode secondLast = getSecondToLast(head);
            secondLast.next.next = head;
            head = secondLast.next;
            secondLast.next = null;
        }

        return head;
    }

    public ListNode getSecondToLast(ListNode head){
        while(head != null && head.next !=null){
            if(head.next.next == null){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public int findNumNodes(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        
        return count;
    }
}