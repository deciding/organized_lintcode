public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    // key !! BFS from 4 edges, O->V, then for all, O->X, V->O
    static int[] dn= new int[]{1,0,-1,0};
	static int[] dm= new int[]{0,-1,0,1};
	public static void bfs(char[][] board, int node){
	LinkedList<Integer> q=new LinkedList<Integer>();
	int m=node/board[0].length,n=node%board[0].length;
	if(board[m][n]!='O') return;
	q.offer(node);
	board[node/board[0].length][node%board[0].length]='V';
	while(!q.isEmpty()){
		int cur=q.poll();
		n=cur%board[0].length;
		m=cur/board[0].length;
		for(int i=0;i<4;i++){
			int m1=m+dm[i];
			int n1=n+dn[i];
			if(m1>=0&&m1<board.length&&n1>=0&&n1<board[0].length&&board[m1][n1]=='O') {
				board[m1][n1]='V';
				q.offer(m1*board[0].length+n1);
			}
		}
	}
	}
  public static void surroundedRegions(char[][] board) {
  // Write your code here
	if(board==null||board.length==0||board[0].length==0) return;
	int m=board.length,n=board[0].length;
	for(int i=0;i<m;i++){
		bfs(board,i*n);
		bfs(board,i*n+n-1);
	}
	for(int i=0;i<n;i++){
		bfs(board,i);
		bfs(board,(m-1)*n+i);
	}
	for(int i=0;i<board.length;i++)
		for(int j=0;j<board[0].length;j++)
			if(board[i][j]=='O') board[i][j]='X';
			else if(board[i][j]=='V') board[i][j]='O';
			
  }
}