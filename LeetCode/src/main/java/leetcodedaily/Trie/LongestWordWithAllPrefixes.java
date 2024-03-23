package leetcodedaily.Trie;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LongestWordWithAllPrefixes {
    private TrieNode root;

    LongestWordWithAllPrefixes() {
        root = new TrieNode();
    }


    public static void main(String[] args) {
        LongestWordWithAllPrefixes l = new LongestWordWithAllPrefixes();
        l.insert("n");
        l.insert("ninja");
        l.insert("ninj");
        l.insert("nin");
        l.insert("ni");
        l.insert("ninga");

        List<String> st = new ArrayList<>();
        st.add("n");
        st.add("ninja");
        st.add("ninj");
        st.add("nin");
        st.add("ni");
        st.add("ninga");


        System.out.println(findLongestWordWithAllPrefix(st, l.root));
    }

    public static String findLongestWordWithAllPrefix(List<String> strings, TrieNode root) {
        String longest = "";
        for (int i = 0; i < strings.size(); i++) {
            if (checkifAllPrefixExist(strings.get(i), root)) {
                if (strings.get(i).length() > longest.length()) {
                    longest = strings.get(i);
                } else if (strings.get(i).length() == longest.length() && strings.get(i).compareTo(longest) < 0) {
                    longest = strings.get(i);
                }
            }
        }
        return longest;
    }

    private static boolean checkifAllPrefixExist(String str, TrieNode root) {
        TrieNode temp = root;

        for (char c : str.toCharArray()) {
            if (temp.getChild(c) == null || !temp.getChild(c).isEndOfWord()) {
                return false;
            }
            temp = temp.getChild(c);
        }
        return temp.isEndOfWord();
    }

    private void insert(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            if (node.getChild(ch) == null) {
                node.setChild(ch, new TrieNode());
            }
            node = node.getChild(ch);
        }
        node.setEndOfWord(true);
    }

}
