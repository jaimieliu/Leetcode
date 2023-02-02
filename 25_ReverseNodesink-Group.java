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
 // Option 1: Manipulate ListNodes - more complicated to reverse 
 // Option 2: make into a list, manipulate - arraylist sort O(nlogn) = not great
 // O(log n) < O(n) < O(n log n) < o(n^2)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> ls = new ArrayList<>();
        ListNode headAfterReverse;      //intialize without instantiating will be null, if instantiate then not null just empty (values inside might be null) but there is an object
        ListNode cur = head;
        ListNode nextHead;
        loop: for(int i = 0; i < k; i++){
            if(cur == null) break loop;
            ls.add(cur);
            cur = cur.next;
        }
        if(cur != null || (cur == null && ls.size() == k)){
            nextHead = cur;

            Collections.reverse(ls);
            headAfterReverse = ls.get(0);
            for(int i = 0; i < ls.size()-1; i++){
                ls.get(i).next = ls.get(i+1);
            }
            ls.get(ls.size()-1).next = reverseKGroup(nextHead, k);   //next head is the head of next segment, same k 
        }
        else{
            headAfterReverse = head;    //return original head of the incomplete segment bc no changes
        }

        return headAfterReverse;
    }
}