package lintcode;
import java.util.*;

   class NBComparator {
      public int cmp(String a, String b){return a.toLowerCase().compareTo(b.toLowerCase());};
  }
 /* You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
	public static void swap(String[] arr,int i,int j){
		String tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	// key !! nust[] bolts[] inter partition !! 
	// key !! we need to record which one is equal to pivot !! and swap it to the correct position at last
	public static int partition(String[] arr, String pivot,int a, int b,NBComparator compare){
		int pivot=a;
		int p=a;
		for(int i=a;i<=b;i++){
			int res1=compare.cmp(arr[i],pivot);
			int res2=compare.cmp(pivot,arr[i]);
			if(res1==-1||res1==0||res2==0||res2==1){// !! we need two compare result, because A>a may not have a<A...
				swap(arr,p++,i);
				if(res1==0||res2==0) pivot=p-1;
			}
		}
		swap(arr,ans,p-1);
		return p-1;
	}
	public static void quicksort(String[] nuts, String[] bolts, NBComparator compare,int l, int r){
		if(l>=r) return;
		int index=partition(nuts,bolts[l],l,r,compare);
		partition(bolts,nuts[index],l,r,compare);
		quicksort(nuts,bolts,compare,l,index-1);
		quicksort(nuts,bolts,compare,index+1,r);
	}
    public static void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
    	if(nuts==null||bolts==null||nuts.length!=bolts.length) return;
    	quicksort(nuts,bolts,compare,0,nuts.length-1);
    }
    public static void main(String[] args){
    	String[] a={"ab","bd","dd","gg"};
    	String[] b={"AB","GG","DD","BC"};
    	sortNutsAndBolts(a,b,new NBComparator());
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(b));
    }
};