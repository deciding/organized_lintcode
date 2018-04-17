/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //reverse recursively, reserve prev, cur, head
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseK(ListNode node, int k, int n){
        if(n==0) return node;
        ListNode prev=null;
        ListNode cur=node;
        for(int i=0;i<k;i++){
            ListNode tmp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
        node.next=reverseK(cur,k,n-1);
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        int len=0;
        ListNode node=head;
        while(node!=null){
            node=node.next;
            len++;
        }
        int n=len/k;
        return reverseK(head,k,n);
    }
}
