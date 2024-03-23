package leetcodedaily.Trie;

import java.util.Collections;

class TrieNodee {

    // implement insert/ count words end with/ count workds start with and/ remove word fucniton
    private static int MAXSIZE = 26;
    private TrieNodee[] children;
    int countWord = 0;
    int countprefix = 0;

    public TrieNodee() {
        children = new TrieNodee[MAXSIZE];
        countWord = 0;
        countprefix = 0;
    }

    public TrieNodee getChild(char ch) {
        return children[ch - 'a'];
    }

    public void setChild(char ch, TrieNodee node) {
        children[ch - 'a'] = node;
    }

    public int getCountprefix() {
        return countprefix;
    }

    public int getCountWord() {
        return countWord;
    }

}

public class TrieOperations {
    private TrieNodee root;

    TrieOperations(){
        root= new TrieNodee();
    }

    public static void main(String[] args) {
        TrieOperations trie = new TrieOperations();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("apps");
        trie.insert("apps");

        // Searching for words in the Trie
        System.out.println(trie.countWordsEndWith("apps")); // 2
        System.out.println(trie.countWordsEndWith("abc"));  //0
        System.out.println(trie.countWordsStartsWith("ap")); //4
        System.out.println(trie.countWordsStartsWith("appl")); //1

        // Checking prefixes in the Trie
        trie.remove("apps");
        System.out.println(trie.countWordsEndWith("apps")); //1
    }

    private void remove(String str) {
        String[] s = str.split(" ");
        TrieNodee node = root;
        for(char ch: str.toCharArray()){
            if(node.getChild(ch) != null){
                node = node.getChild(ch);
                node.countprefix--;
            }
        }
        node.countWord--;
    }

    private int countWordsStartsWith(String str) {
        TrieNodee node = root;
        for(char ch: str.toCharArray()){
            if(node.getChild(ch) != null){
                node = node.getChild(ch);
            }
        }
        return node.countprefix;
    }

    private int countWordsEndWith(String str) {
        TrieNodee node = root;
        for(char ch: str.toCharArray()){
            if(node.getChild(ch) != null){
                node = node.getChild(ch);
            }
        }
        return node.countWord;
    }

    private void insert(String str) {
        TrieNodee node = root;

        for(char c: str.toCharArray()){
            if(node.getChild(c) == null){
                node.setChild(c, new TrieNodee());
            }
            node = node.getChild(c);
            node.countprefix++;
        }
        node.countWord++;
    }
}
