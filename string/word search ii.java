public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    class TrieNode{
        HashMap<Character,TrieNode> children;
        boolean isWord;
        TrieNode(){
            children=new HashMap<Character,TrieNode>();
            isWord=false;
        }
    }
    TrieNode root=new TrieNode();
    public void add(String str){
        if(str==null) return;
        TrieNode cur=root;
        for(int i=0;i<str.length();i++)
        if(cur.children.containsKey(str.charAt(i))) cur=cur.children.get(str.charAt(i));
        else{
            cur.children.put(str.charAt(i),new TrieNode());
            cur=cur.children.get(str.charAt(i));
        }
        cur.isWord=true;
    }
    
    int[] di=new int[]{-1,1,0,0};
    int[] dj=new int[]{0,0,-1,1};
    void dfs(char[][] board, int i, int j, String oneAns, ArrayList<String> ans, TrieNode tr, HashSet<String> visited){
        int m=board.length;
        int n=board[0].length;
        if(i<0||j<0||i>=m||j>=n) return;
        char tmp=board[i][j];
        if(!tr.children.containsKey(tmp)) return;
        tr=tr.children.get(tmp);
        if(tr.isWord&&!visited.contains(oneAns+tmp)) {
            ans.add(oneAns+tmp);
            visited.add(oneAns+tmp);
        }
        board[i][j]='$';
        for(int k=0;k<4;k++)
        dfs(board,i+di[k],j+dj[k],oneAns+tmp,ans,tr,visited);
        board[i][j]=tmp;
    }
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> ans= new ArrayList<>();
        int m=board.length;
        if(m==0) return ans;
        int n=board[0].length;
        if(n==0) return ans;
        for(int i=0;i<words.size();i++)
        add(words.get(i));
        
        HashSet<String> visited=new HashSet<String>();
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        dfs(board,i,j,"",ans,root,visited);
        return ans;
    }
}
