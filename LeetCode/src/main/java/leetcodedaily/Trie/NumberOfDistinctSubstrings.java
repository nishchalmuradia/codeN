package leetcodedaily.Trie;

public class NumberOfDistinctSubstrings {

    private TrieNode root;

    NumberOfDistinctSubstrings(){
        root= new TrieNode();
    }

    public static void main(String[] args) {
        NumberOfDistinctSubstrings n = new NumberOfDistinctSubstrings();

        System.out.println(noOfDistinctSubstring("abab", n.root));
    }

    private static int noOfDistinctSubstring(String str, TrieNode root) {
        int counter = 1;// 1 is for empty substring
       // TrieNode node = root;
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++){
            TrieNode node = root;
            for(int j=i ; j<chars.length;j++){
                if(node.getChild(chars[j]) == null){
                    counter++;
                    node.setChild(chars[j], new TrieNode());
                }
                node = node.getChild(chars[j]);
            }

        }
        return counter;
    }
}
