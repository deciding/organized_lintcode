package lintcode;
import java.util.*;
//idea :1st round mark o_node->number
//2nd round mark number -> n_node
//3rd round o_node->n_node for each random field
//improve: 1. use o_node->n_node, 2. use 1 round
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
//!!method 2, first round 1->1'->2->2'..., second round separate, easy for random points, no need hashmap
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    // map is the key !! map from old node to new node
    // node, next, random
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        HashMap<RandomListNode,RandomListNode> map= new HashMap<RandomListNode,RandomListNode>();
        RandomListNode cur=head;
        RandomListNode dummy=new RandomListNode(0);
        RandomListNode new_cur=dummy;
        RandomListNode node;
        RandomListNode rand;
        while(cur!=null){
            // cur node may have been added by random !!
            if(map.containsKey(cur)) node=map.get(cur);
            else {
                node=new RandomListNode(cur.label);
                map.put(cur,node);
            }
            new_cur.next=node;
            new_cur=new_cur.next;
            rand=null;
            // random may have been added by cur !!
            if(cur.random!=null&&map.containsKey(cur.random)) rand=map.get(cur.random);
            else if(cur.random!=null){
                rand=new RandomListNode(cur.random.label);
                map.put(cur.random,rand);
            }
            node.random=rand;
            cur=cur.next;
        }
        return dummy.next;
    }
}
