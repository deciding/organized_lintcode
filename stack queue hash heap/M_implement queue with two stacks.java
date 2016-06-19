package lintcode;
import java.util.*;


// Version A:

//     push:
//         enqueue in queue1
//     pop:
//         while size of queue1 is bigger than 1, pipe dequeued items from queue1 into queue2
//         dequeue and return the last item of queue1, then switch the names of queue1 and queue2

// Version B:

//     push:
//         enqueue in queue2
//         enqueue all items of queue1 in queue2, then switch the names of queue1 and queue2
//     pop:
//         deqeue from queue1


public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1=new Stack<Integer>();
       stack2=new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if(stack2.isEmpty())
        while(!stack1.isEmpty())
        stack2.push(stack1.pop());
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if(stack2.isEmpty())
        while(!stack1.isEmpty())
        stack2.push(stack1.pop());
        return stack2.peek();
    }
}