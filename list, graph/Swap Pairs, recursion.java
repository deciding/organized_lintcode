package lintcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode temp=head.next;
        head.next=temp.next;
        temp.next=head;
        head.next=swapPairs(head.next);
        return temp;
    }
}