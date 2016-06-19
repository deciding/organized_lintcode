public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    //shunting's algorithm !!
    
    public ArrayList<String> convertToRPN(String[] expression) {
        // write your code here
        HashMap<String,Integer> precedence=new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        ArrayList<String> queue =new ArrayList<>();
        Stack<String> stack=new Stack<>();
        Set<String> ops=precedence.keySet();
        for(int i=0;i<expression.length;i++){
        	String item=expression[i];
        	if(ops.contains(item)){
        		while(!stack.isEmpty()&&!stack.peek().equals("(")&&precedence.get(stack.peek())>=precedence.get(item))
        			queue.add(stack.pop());
        		stack.push(item);
        	}
        	else if(item.equals("(")) stack.push(item);
        	else if(item.equals(")")) {
        		while(!stack.peek().equals("(")) queue.add(stack.pop());
        		stack.pop();
        	}
        	else if(item.matches("^\\d+$"))	queue.add(item);
        }
        while(!stack.isEmpty())
        	queue.add(stack.pop());
        return queue;
    }
}