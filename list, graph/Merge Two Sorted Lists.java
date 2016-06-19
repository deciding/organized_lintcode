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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode ans=new ListNode(0);
        ListNode cur1=l1,cur2=l2,dummy=new ListNode(0),cur3=dummy;
        
        while(cur1!=null && cur2!=null){
            ListNode tmp=new ListNode(0);
            if(cur1.val<cur2.val){
                tmp.val=cur1.val;
                cur1=cur1.next;
            }
            else{
                tmp.val=cur2.val;
                cur2=cur2.next;
            }
            cur3.next=tmp;
            cur3=cur3.next;
        }
        cur3.next=cur1==null?cur2:cur1;
        return dummy.next;
    }
}
