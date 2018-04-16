/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public void createNode(Stack<ExpressionTreeNode> nums, Stack<String> ops){
        ExpressionTreeNode node=new ExpressionTreeNode(ops.pop());
        node.right=nums.pop();
        node.left=nums.pop();
        nums.push(node);
    }
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        Stack<ExpressionTreeNode> nums=new Stack<>();
        Stack<String> ops=new Stack<>();
        HashMap<String,Integer> precedence=new HashMap<>();
        precedence.put("+",1);
        precedence.put("-",1);
        precedence.put("*",2);
        precedence.put("/",2);
        Set<String> OPS=precedence.keySet();
        for(int i=0;i<expression.length;i++){
            String cur=expression[i];
            if(OPS.contains(cur)){
                while(!ops.isEmpty()&&!ops.peek().equals("(")&&precedence.get(cur)<=precedence.get(ops.peek()))
                    createNode(nums,ops);
                ops.push(cur);
            }
            else if(cur.equals("(")) ops.push(cur);
            else if(cur.equals(")")){
                while(!ops.isEmpty()&&!ops.peek().equals("("))
                    createNode(nums,ops);
                ops.pop();
            }
            else if(cur.matches("^\\d+$")) nums.push(new ExpressionTreeNode(cur));
        }
        while(!ops.isEmpty())
            createNode(nums,ops);
        return nums.isEmpty()?null:nums.pop();
    }
}
