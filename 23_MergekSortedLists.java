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
    public ListNode mergeKLists(ListNode[] lists) {
        // Option 1: add all to list, then sort, then go from list -> linkedlist
        // Option 2: look for head of each list and find minimum, set to head, head.next = next minimum, that is head


        List<ListNode> list = new ArrayList<>();
        if(lists.length == 1){
            return lists[0];
        }
        // Option 1 
        for(ListNode ls: lists){
            ListNode head = ls;
            while(head != null){
                list.add(head);
                head = head.next;
            }
        }

        list.sort(Comparator.comparing(o -> o.val));

        ListNode cur = new ListNode();
        ListNode out = new ListNode();
        
        if(list.size() == 1){
            return list.get(0);
        }
        else if(!list.isEmpty()){
            cur = list.get(0);
            out = cur;
        }
        else{
            return null;
        }

        for(ListNode el: list){
            cur.next = el;
            cur = cur.next;
        }

        return out;

        
        // Option 2
    }
}