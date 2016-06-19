import java.util.*;

// just binary search
public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    // intro !! L[i] length, k woods, we need max cutted wood length
    
	public static int getMax(int[] L){
		int max=Integer.MIN_VALUE;
		for(int i=0;i<L.length;i++)
			max=Math.max(max, L[i]);
		return max;
	}
	public static int pieces(int[] L, int len){
		int ans=0;
		for(int i=0;i<L.length;i++)
			ans+=L[i]/len;
		return ans;
	}
    public static int woodCut(int[] L, int k) {
        // write your code here
    	if(L==null||L.length==0) return 0;
    	int max=getMax(L);
    	if(max==0) return 0;
    	int a=1, b=max;
    	while(a+1<b){
    		int mid=a+(b-a)/2;// much safer than (a+b)/2
    		if(pieces(L,mid)>=k) a=mid;
    		else b=mid;
    	}
    	if(pieces(L,b)>=k) return b;
    	if(pieces(L,a)>=k) return a;
    	return 0;
    }
    public static void main(String[] args){
    	System.out.println(woodCut(new int[]{2147483644,2147483645,2147483646,2147483647
    			},4));
    }
}