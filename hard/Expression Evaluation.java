public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public void doOneCal(Stack<Integer> nums,Stack<String> ops){
        String op=ops.pop();
        int num2=nums.pop();
        int num1=nums.pop();
        if(op.equals("+")) nums.push(num1+num2);
        else if(op.equals("-")) nums.push(num1-num2);
        else if(op.equals("*")) nums.push(num1*num2);
        else if(op.equals("/")) nums.push(num1/num2);
    }
    public int evaluateExpression(String[] expression) {
        // write your code here
        if(expression.length==0) return 0;
        Stack<Integer> nums=new Stack<>();
        Stack<String> ops= new Stack<>();
        HashMap<String,Integer> precedence=new HashMap<>();
        precedence.put("+",1);
        precedence.put("-",1);
        precedence.put("*",2);
        precedence.put("/",2);
        Set<String> OPS=precedence.keySet();
        for(int i=0;i<expression.length;i++){
            String cur=expression[i];
            if(OPS.contains(cur)){
                while(!ops.isEmpty()&&!ops.peek().equals("(")&&precedence.get(cur)<=precedence.get(ops.peek())){
                    doOneCal(nums,ops);
                }
                ops.push(cur);
            }
            else if(cur.equals("(")) ops.push(cur);
            else if(cur.equals(")")) {
                while(!ops.isEmpty()&&!ops.peek().equals("("))
                    doOneCal(nums,ops);
                ops.pop();
            }
            else if(cur.matches("^\\d+$")) nums.push(Integer.parseInt(cur));
        }
        while(!ops.isEmpty())
            doOneCal(nums,ops);
        return nums.isEmpty()?0:nums.pop();
    }
};
