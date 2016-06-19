//back to front
//insert help function
//backtrack insert
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
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
     public ListNode insert(ListNode node, ListNode head){
         if(head==null||head.val>=node.val) {
             node.next=head;
             return node;
         }
         ListNode cur=head;
         ListNode prev=head;
         while(cur!=null){
             if(node.val>cur.val){
                 prev=cur;
                 cur=cur.next;
             }
            else break; 
         }
         prev.next=node;
         node.next=cur;
         return head;
     }
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head==null) return head;
        return insert(head,insertionSortList(head.next));
    }
}
