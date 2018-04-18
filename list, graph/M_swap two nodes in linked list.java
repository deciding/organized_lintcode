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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if(head==null) return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev1=null, prev2=null;
        ListNode cur=dummy;
        while(cur.next!=null){
            if(cur.next.val==v1||cur.next.val==v2)
            if(prev1==null) prev1=cur;
            else prev2=cur;
            cur=cur.next;
        }
        if(prev1==null||prev2==null) return head;
        ListNode tmp=prev1.next;
        prev1.next=prev2.next;
        prev2.next=tmp;
        tmp=prev1.next.next;
        prev1.next.next=prev2.next.next;
        prev2.next.next=tmp;
        return dummy.next;
    }
}
