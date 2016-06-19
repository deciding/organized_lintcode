/**
 * Definition for singly-linked list.
 */

public class Solution {
    
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        int c=0;
        int val;
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        // add !!
        while(l1!=null&&l2!=null){
            val=l1.val+l2.val+c;
            c=val/10;
            val%=10;
            cur.next=new ListNode(val);
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        // addtional !!
        while(l1!=null){
            val=l1.val+c;
            c=val/10;
            val%=10;
            cur.next=new ListNode(val);
            cur=cur.next;
            l1=l1.next;
        }
        while(l2!=null){
            val=l2.val+c;
            c=val/10;
            val%=10;
            cur.next=new ListNode(val);
            cur=cur.next;
            l2=l2.next;
        }
        // carry !!
        if(c!=0)
            cur.next=new ListNode(c);
        return dummy.next;
    }
}
