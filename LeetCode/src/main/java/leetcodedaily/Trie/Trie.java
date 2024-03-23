package leetcodedaily.Trie;

class TrieNode {

    private static int SIZE = 26;

    //array to store reference node
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[SIZE];
        isEndOfWord = false;
    }

    public TrieNode getChild(char ch) {
        return children[ch - 'a'];
    }

    public void setChild(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private boolean startsWith(String str) {
        TrieNode node = root;
        for(char ch : str.toCharArray()){
            if(node.getChild(ch)==null){
                return false;
            }
            node = node.getChild(ch);
        }
        return true;
    }

    private boolean search(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            if (node.getChild(ch) == null) {
                return false;
            }
            node = node.getChild(ch);
            if(node.isEndOfWord()){
                return true;
            }
        }
        return false;
    }

    private void insert(String str) {
        TrieNode node = root;
        for (char c : str.toCharArray()) {
            if (node.getChild(c) == null) {
                node.setChild(c, new TrieNode());
            }
            node = node.getChild(c);
        }
        node.setEndOfWord(true);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");

        // Searching for words in the Trie
        System.out.println(trie.search("apple"));    // Output: true
        System.out.println(trie.search("app"));      // Output: true
        System.out.println(trie.search("apricot"));  // Output: true
        System.out.println(trie.search("ap"));        // Output: false

        // Checking prefixes in the Trie
        System.out.println(trie.startsWith("ap"));    // Output: true
        System.out.println(trie.startsWith("ban"));   // false
    }
}
