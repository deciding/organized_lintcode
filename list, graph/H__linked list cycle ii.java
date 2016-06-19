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
// len(a)-----len(b)
//      /          \
//     /            \
//     |             \
//     |              |
//     |              /
//      \             len(c)
//       \           /
//        \         /
//         ---------
// a-1+b+c+b=2(a+b)
// c-1=a !!


public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        if(head==null||head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=slow){
            if(slow==null||fast==null||fast.next==null) return null;
            slow=slow.next;
            fast=fast.next.next;
        }
        while(slow.next!=head){
            slow=slow.next;
            head=head.next;
        }
        return head;
    }
}
