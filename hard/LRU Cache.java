public class Solution {
    //HashMap -> get set
    //Double linked list -> pop(i)
    class ListNode{
        int key;
        int val;
        ListNode next,prev;
        ListNode(int key, int val){
            this.key=key;
            this.val=val;
            next=null;
            prev=null;
        }
    }
    class LRUCache{
        HashMap<Integer,ListNode> cache;
        ListNode head,tail;
        int size, capacity;
        LRUCache(int capacity){
            cache=new HashMap<Integer,ListNode>();
            head=new ListNode(0,0);
            tail=new ListNode(0,0);
            head.next=tail;tail.prev=head;
            size=0;
            this.capacity=capacity;
        }
        void use(ListNode node){
            ListNode prev=node.prev, next=node.next;
            if(prev!=null)
                prev.next=next;
            if(next!=null)
                next.prev=prev;
            ListNode tmp=head.next;
            head.next=node;node.prev=head;
            node.next=tmp;tmp.prev=node;
        }
        ListNode pop(){
            if(size==0) return null;
            ListNode node=tail.prev;
            ListNode prev=node.prev;
            tail.prev=prev;prev.next=tail;
            size--;
            return node;
        }
        int get(int key){
            if(!cache.containsKey(key)) return -1;
            ListNode node=cache.get(key);
            use(node);
            return node.val;
        }
        void set(int key, int val){
            if(cache.containsKey(key)){
                ListNode node=cache.get(key);
                node.val=val;
                use(node);
                return;
            }
            if(size>=capacity){
                ListNode node=pop();
                cache.remove(node.key);
            }
            ListNode node= new ListNode(key,val);
            size++;
            cache.put(key,node);
            use(node);
        }
    }
    LRUCache cache;
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        cache= new LRUCache(capacity);
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        return cache.get(key);
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        cache.set(key,value);
    }
}
