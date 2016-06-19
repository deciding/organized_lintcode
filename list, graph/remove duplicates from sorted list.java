/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        ListNode cur=head;
        while(cur!=null){
        while(cur.next!=null&&cur.val==cur.next.val)
            cur.next=cur.next.next;
        cur=cur.next;
        }
        return head;
    }  
}