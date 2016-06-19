/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
// key !! 2 pointers
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode last=head, cur=head;
        while(n>0){
            last=last.next;
            n--;
        }
        while(last!=null){
            cur=cur.next;
            last=last.next;
        }
        return cur;
    }
}

