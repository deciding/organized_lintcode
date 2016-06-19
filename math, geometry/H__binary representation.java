import java.util.*;
//check binary iterative float bits
public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
	public static String int2bin(int val){
		if(val==0) return "0";
		String ans="";
		while(val>0){
			ans=(val%2==0?"0":"1")+ans;
			val=val/2;
		}
		return ans;
	}
	public static String double2bin(double val){
		String ans="";
		HashSet<Double> checkIterative=new HashSet<Double>();
		while(val>0){
            // key !! check whether it's a iterative floating number
			if(ans.length()>32||checkIterative.contains(val)) return "ERROR";
			checkIterative.add(val);
			val*=2;
			if(val>=1){
				val-=1;
				ans=ans+"1";
			}
			else ans=ans+"0";
		}
		return ans;
	}
    public static String binaryRepresentation(String n) {
        // write your code here
    	if(n==null||n=="") return "0";
    	String[] parts=n.split("\\.");// key !! regexp
    	if(parts.length!=2) return int2bin(Integer.parseInt(parts[0]));//->127. 127
    	int intPart=0;
    	if(parts[0]!=null&&!parts[0].equals("")) //.5
    		intPart=Integer.parseInt(parts[0]);
    	double floatPart=0.0;
    	if(parts[1]!=null&&!parts[1].equals("")) //will not happen
    		floatPart=Double.parseDouble("0."+parts[1]);
    	String i=int2bin(intPart);
    	String d=double2bin(floatPart);
    	if(d.equals("")) return i;//d->0
    	if(d.equals("ERROR")) return "ERROR";
    	return i+"."+d;
    }
    public static void main(String[] args){
    	String str="0000.";
    	System.out.println(Arrays.toString(str.split("\\.")));// !!
    	
    }
}