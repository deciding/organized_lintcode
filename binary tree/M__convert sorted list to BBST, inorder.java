package lintcode;
import java.util.*;

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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
// key !! 1. inorder, 2. length
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    ListNode inorder;//D&C key !
    public TreeNode constructBBST(int length){
        if(length==0) return null;
        TreeNode node= new TreeNode(0);
        node.left=constructBBST(length/2);
        node.val=inorder.val;
        inorder=inorder.next;
        node.right=constructBBST(length-length/2-1);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            length++;
        }
        inorder=head;
        return constructBBST(length);
    }
}
