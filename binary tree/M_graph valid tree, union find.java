package lintcode;
import java.util.*;
class UnionFind{
	private ArrayList<Integer> p,rank,setSize;
	private int setNum;
	public UnionFind(int n){
		p=new ArrayList<Integer>();rank=new ArrayList<Integer>();setSize=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			p.add(i);rank.add(0);setSize.add(1);
		}
		setNum=n;
	}
	public int findSet(int n){
		if(p.get(n)==n) return n;
		int ans= findSet(p.get(n));
		p.set(n, ans);
		return ans;
	}
	public boolean isSameSet(int i, int j){
		return findSet(i)==findSet(j);
	}
	public void unionSet(int i, int j){
		int x=findSet(i);
		int y=findSet(j);
		if(x==y) return;
		setNum--;
		if(rank.get(x)>rank.get(y)){
			p.set(y, x);
			setSize.set(x, setSize.get(x)+setSize.get(y));
		}
		else {
			p.set(x, y);
			setSize.set(y, setSize.get(x)+setSize.get(y));
			if(rank.get(x)==rank.get(y))
				rank.set(y, rank.get(y)+1);
		}
	}
	public int numOfSets(){
		return setNum;
	}
	public int sizeOfSet(int i){
		return setSize.get(findSet(i));
	}
}
public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
	public boolean validTree(int n, int[][] edges) {
        // Write your code here
		if(edges.length!=n-1) return false;
		UnionFind UF=new UnionFind(n);
		for(int i=0;i<edges.length;i++)
			UF.unionSet(edges[i][0], edges[i][1]);
		return UF.numOfSets()==1?true:false;
    }
}