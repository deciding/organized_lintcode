/**
* 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
* - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
* - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
* - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
* - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
*/ 

// TreeMap Version
import java.util.*;
//cnblog
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1; // 结果的尺寸
        double[] res = new double[m];
        //两个堆，一个最大堆，一个最小
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for ( int i=0; i<n; i++){
            int num = nums[i];
            // 让maxHeap始终保存小于一半的值，minHeap保存大于一半的，正好两半
            if( maxHeap.size() == 0 || maxHeap.peek() >= num)
                maxHeap.add(num);
            else minHeap.add(num);
            // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
            if( minHeap.size() > maxHeap.size() )
                maxHeap.add(minHeap.poll());
            if( maxHeap.size() > minHeap.size() + 1 )
                minHeap.add(maxHeap.poll());
            // 如果需要输出
            if ( i-k+1 >=0 ){
                if( k % 2 == 1 )
                    res[i- k + 1] = maxHeap.peek();
                else 
                    res[i- k + 1] = (maxHeap.peek()/2.0 + minHeap.peek()/2.0); // 小心溢出
                //移除并更新
                int toBeRemove = nums[i - k + 1];
                if( toBeRemove <= maxHeap.peek())
                    maxHeap.remove(toBeRemove);
                else minHeap.remove(toBeRemove);
                // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
                if( minHeap.size() > maxHeap.size() )
                    maxHeap.add(minHeap.poll());
                if( maxHeap.size() > minHeap.size() + 1 )
                    minHeap.add(maxHeap.poll());

            }
        }
        return res;

    }
}

public class Solution {
    /**
	 * @param nums
	 *            : A list of integers.
	 * @return: The median of the element inside the window at each moving.
	 */
	public  ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
	    int n = nums.length;
        TreeSet<Node> minheap = new TreeSet<Node>();
        TreeSet<Node> maxheap = new TreeSet<Node>();
        ArrayList<Integer> result = new ArrayList<Integer> ();
        
        if (k == 0)
            return result;
        
        int half = (k+1)/2;
        for(int i=0; i<k-1; i++) {
            add(minheap, maxheap, half, new Node(i, nums[i]));
        }
        for(int i=k-1; i<n; i++) {
            add(minheap, maxheap, half, new Node(i, nums[i]));
            result.add(minheap.last().val);
            remove(minheap,maxheap, new Node(i-k+1, nums[i-k+1]));
        }
        return result;
    }
    
    void add(TreeSet<Node>minheap, TreeSet<Node> maxheap, int size, Node node) {
        if (minheap.size()<size) {
            minheap.add(node);
        }
        else {
            maxheap.add(node);
        }
        if (minheap.size()==size) {
            if (maxheap.size()>0 && minheap.last().val>maxheap.first().val) {
                Node s = minheap.last();
                Node b = maxheap.first();
                minheap.remove(s);
                maxheap.remove(b);
                minheap.add(b);
                maxheap.add(s);
            }
        }
    }
    
    void remove(TreeSet<Node>minheap, TreeSet<Node> maxheap, Node node) {
        if (minheap.contains(node)) {
            minheap.remove(node);
        }
        else {
            maxheap.remove(node);
        }
    }
}

class Node implements Comparable<Node>{
    int id;
    int val;
    Node(int id, int val) {
        this.id = id;
        this.val = val;
    }
    public int compareTo(Node other) {
        Node a =(Node)other;
        if (this.val == a.val) {
            return this.id - a.id;
        }
        return this.val - a.val;
    }
}


// Normal heap Version
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        int size = nums.length;
        if (size == 0 || size < k) {
            return result;
        }

        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(11, Collections.reverseOrder());

        int median = nums[0];
        int j = 0;
        if (k == 1) {
            result.add(median);
        }

        for (int i = 1; i < size; i++) {
            if (nums[i] > median) {
                minPQ.offer(nums[i]);
            } else {
                maxPQ.offer(nums[i]);
            }

            if (i > k - 1) {
                if (nums[j] > median) {
                    minPQ.remove(nums[j]);
                } else if (nums[j] < median) {
                    maxPQ.remove(nums[j]);
                } else {
                    median = Integer.MIN_VALUE;
                }
                j++;
            }

            if (median == Integer.MIN_VALUE) {
                median = minPQ.size() > maxPQ.size() ? minPQ.poll() : maxPQ.poll();
            } else {
                while (minPQ.size() >= maxPQ.size() + 2) {
                    maxPQ.offer(median);
                    median = minPQ.poll();
                }
                while (maxPQ.size() >= minPQ.size() + 1) {
                    minPQ.offer(median);
                    median = maxPQ.poll();
                }
            }
            if (i >= k - 1) {
                result.add(median);
            }
        }

        return result;
    }
}

// Hash Heap Version
import java.util.*;

class HashHeap {
    ArrayList<Integer> heap;
    String mode;
    int size_t;
    HashMap<Integer, Node> hash;

    class Node {
        public Integer id;
        public Integer num;

        Node(Node now) {
            id = now.id;
            num = now.num;
        }

        Node(Integer first, Integer second) {
            this.id = first;
            this.num = second;
        }
    }

    public HashHeap(String mod) {
        // TODO Auto-generated constructor stub
        heap = new ArrayList<Integer>();
        mode = mod;
        hash = new HashMap<Integer, Node>();
        size_t = 0;
    }

    int peak() {
        return heap.get(0);
    }

    int size() {
        return size_t;
    }

    Boolean empty() {
        return (heap.size() == 0);
    }

    int parent(int id) {
        if (id == 0) {
            return -1;
        }
        return (id - 1) / 2;
    }

    int lson(int id) {
        return id * 2 + 1;
    }

    int rson(int id) {
        return id * 2 + 2;
    }

    boolean comparesmall(int a, int b) {
        if (a <= b) {
            if (mode == "min")
                return true;
            else
                return false;
        } else {
            if (mode == "min")
                return false;
            else
                return true;
        }

    }

    void swap(int idA, int idB) {
        int valA = heap.get(idA);
        int valB = heap.get(idB);

        int numA = hash.get(valA).num;
        int numB = hash.get(valB).num;
        hash.put(valB, new Node(idA, numB));
        hash.put(valA, new Node(idB, numA));
        heap.set(idA, valB);
        heap.set(idB, valA);
    }

    Integer poll() {
        size_t--;
        Integer now = heap.get(0);
        Node hashnow = hash.get(now);
        if (hashnow.num == 1) {
            swap(0, heap.size() - 1);
            hash.remove(now);
            heap.remove(heap.size() - 1);
            if (heap.size() > 0) {
                siftdown(0);
            }
        } else {
            hash.put(now, new Node(0, hashnow.num - 1));
        }
        return now;
    }

    void add(int now) {
        size_t++;
        if (hash.containsKey(now)) {
            Node hashnow = hash.get(now);
            hash.put(now, new Node(hashnow.id, hashnow.num + 1));

        } else {
            heap.add(now);
            hash.put(now, new Node(heap.size() - 1, 1));
        }

        siftup(heap.size() - 1);
    }

    void delete(int now) {
        size_t--;
        ;
        Node hashnow = hash.get(now);
        int id = hashnow.id;
        int num = hashnow.num; 
        if (hashnow.num == 1) {

            swap(id, heap.size() - 1);
            hash.remove(now);
            heap.remove(heap.size() - 1);
            if (heap.size() > id) {
                siftup(id);
                siftdown(id);
            }
        } else {
            hash.put(now, new Node(id, num - 1));
        }
    }

    void siftup(int id) {
        while (parent(id) > -1) {
            int parentId = parent(id);
            if (comparesmall(heap.get(parentId), heap.get(id)) == true) {
                break;
            } else {
                swap(id, parentId);
            }
            id = parentId;
        }
    }

    void siftdown(int id) {
        while (lson(id) < heap.size()) {
            int leftId = lson(id);
            int rightId = rson(id);
            int son;
            if (rightId >= heap.size() || (comparesmall(heap.get(leftId), heap.get(rightId)) == true)) {
                son = leftId;
            } else {
                son = rightId;
            }
            if (comparesmall(heap.get(id), heap.get(son)) == true) {
                break;
            } else {
                swap(id, son);
            }
            id = son;
        }
    }
}

public class Solution {
    /**
     * @param nums
     *            : A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here

        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (nums.length == 0)
            return ans;
        int median = nums[0];
        HashHeap minheap = new HashHeap("min");
        HashHeap maxheap = new HashHeap("max");
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                if (nums[i] > median) {
                    minheap.add(nums[i]);
                } else {
                    maxheap.add(nums[i]);
                }
            }

            if (i >= k) {
                if (median == nums[i - k]) {
                    if (maxheap.size() > 0) {
                        median = maxheap.poll();
                    } else if (minheap.size() > 0) {
                        median = minheap.poll();
                    } 

                } else if (median < nums[i - k]) {
                    minheap.delete(nums[i - k]);
                } else {
                    maxheap.delete(nums[i - k]);
                }
            }

            while (maxheap.size() > minheap.size()) {
                minheap.add(median);
                median = maxheap.poll();
            }
            while (minheap.size() > maxheap.size() + 1) {
                maxheap.add(median);
                median = minheap.poll();
            }

            if (i + 1 >= k) {
                ans.add(median);
            }
        }
        return ans;
    }
}
