package lintcode;
import java.util.*;
/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public HashMap<Character,TrieNode> children;// key !!
    boolean isWord;
    public TrieNode() {
        children=new HashMap<Character,TrieNode>();
        isWord=false;
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!cur.children.containsKey(ch))
            cur.children.put(ch,new TrieNode());
            cur=cur.children.get(ch);
        }
        cur.isWord=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!cur.children.containsKey(ch))
            return false;
            cur=cur.children.get(ch);
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(!cur.children.containsKey(ch))
            return false;
            cur=cur.children.get(ch);
        }
        return true;
    }
}