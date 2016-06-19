import java.util.*;

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */   
	public void add(ListNode[] hashTable, int val){
		int size=hashTable.length;
		int index=(val%size+size)%size;// key !! a % b = (a % b + b) % b to make it is a non negative integer.
		if(hashTable[index]==null)
			hashTable[index]=new ListNode(val);
		else {
			ListNode cur=hashTable[index];
			while(cur.next!=null) cur=cur.next;
			cur.next=new ListNode(val);
		}
	}
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
    	int size=hashTable.length;
    	ListNode[] ansTable=new ListNode[2*size];
    	for(int i=0;i<size;i++){
    		ListNode cur=hashTable[i];
    		while(cur!=null){
    			add(ansTable,cur.val);
    			cur=cur.next;
    		}
    	}
    	return ansTable;
    }
};

