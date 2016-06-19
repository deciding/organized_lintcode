package lintcode;
import java.util.*;
//dictionary trie
class TrieNode{
	public HashMap<Character,TrieNode> children;
	public boolean isWord;
	public TrieNode(){
		children=new HashMap<Character,TrieNode>();
		isWord=false;
	}
}
public class WordDictionary {
	private TrieNode root;
	public WordDictionary(){
		root=new TrieNode();
	}
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
    	TrieNode cur=root;
    	for(int i=0;i<word.length();i++){
    		if(!cur.children.containsKey(word.charAt(i)))
    			cur.children.put(word.charAt(i), new TrieNode());
    		cur=cur.children.get(word.charAt(i));
    	}
    	cur.isWord=true;
    }
    
    private boolean find(String word, int index, TrieNode cur){
    	if(index==word.length()) return cur.isWord;
    	if(word.charAt(index)=='.'){
    		for(Map.Entry<Character, TrieNode> pair:cur.children.entrySet())
    			if(find(word,index+1,pair.getValue()))
    				return true;
    		return false;
    	}
    	if(cur.children.containsKey(word.charAt(index)))
    		return find(word,index+1,cur.children.get(word.charAt(index)));
    	else return false;
    }
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
    	return find(word,0,root);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");