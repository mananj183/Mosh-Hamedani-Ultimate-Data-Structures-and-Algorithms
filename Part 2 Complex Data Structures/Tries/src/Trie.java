import java.util.*;

public class Trie {
    public static int ALPHABET_SIZE = 26;
    private class Node{
        char value;
        Map<Character, Node> children = new HashMap<>();
        boolean isEndOfWord;
        public Node(char value){
            this.value = value;
        }
        public boolean hasAChild(char c){
            return children.containsKey(c);
        }
        public void addChild(char c){
            children.put(c, new Node(c));
        }
        public Node getChild(char c){
            return children.get(c);
        }
        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }
        public boolean hasChildren(){
            return !children.isEmpty();
        }
        public void removeChild(char c){
            children.remove(c);
        }


        @Override
        public String toString() {
            return "value=" + value;
        }
    }
    Node root = new Node(' ');
    public void insert(String s){
        Node current = root;
        for (char c:s.toCharArray()){
            if (!current.hasAChild(c)){
                current.addChild(c);
            }
            current = current.getChild(c);
        }
        current.isEndOfWord = true;
    }
    public boolean contains(String word){
        if (word==null)
            return false;
        if (word== " " || word ==""){
            return true;
        }

        Node current = root;
        for(char c:word.toCharArray()){
            if (!current.hasAChild(c))
                return false;
            current = current.getChild(c);
        }
        return current.isEndOfWord;
    }
    public List<String> traversal(){
        List<String> words = new ArrayList<>();
        traversal(root,"",words);
        return words;
    }
    private void traversal(Node root, String word, List<String> words){
//        System.out.println(root.value + " " + Arrays.toString(root.getChildren()));
        if(root.value != ' '){
            word += root.value ;
        }
        if (root.isEndOfWord) {
            words.add(word);
        }
        for (Node n : root.getChildren()){
            traversal(n,word,words);
        }
    }

    public void removeWord(String word){
        if (word == null)
            return;

        removeWord(root, word, 0);
    }
    private void removeWord(Node root, String word, int index){
        if (index == word.length()){
            root.isEndOfWord = false;
            return;
        }

        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child==null)
            return;
        removeWord(child, word, index+1);

        if (!child.hasChildren() && !child.isEndOfWord){
            root.removeChild(child.value);
        }
    }

    public void autoComplete(String prefix){
        if (prefix == null){
            return;
        }
        List<String> words = new ArrayList<>();
        Node child = root;
        if (prefix.trim()==""){
            autoComplete(child, prefix.trim(), words);
            System.out.println(words);
            return;
        }

        for (char ch:prefix.toCharArray()) {
            child = child.getChild(ch);
            if (child == null){
                return;
            }
        }
        autoComplete(child, prefix.substring(0,prefix.length()-1), words);
        System.out.println(words);
    }
    private void autoComplete(Node root, String prefix, List<String> words){
        if(root.value != ' '){
            prefix += root.value ;
        }
        if (root.isEndOfWord) {
            words.add(prefix);
        }
        for (Node n : root.getChildren()){
            traversal(n,prefix,words);
        }
    }
    public int countWords(){
        return traversal().size();
    }

    public String longestCommonPrefix(String[] words){
        Trie trie = new Trie();
        for (String word: words)
            trie.insert(word);
        List<String> longestPrefix = new ArrayList<>();
        String word = "";
        longestCommonPrefix(trie.root, word, longestPrefix);
        return longestPrefix.get(0);
    }
    private void longestCommonPrefix( Node current, String word, List<String> longestPrefix){
        if (current.getChildren().length >= 2 || current.isEndOfWord){
            if (current.value!= ' ') {
                word += current.value;
            }
            longestPrefix.add(word);
            return;
        }
        if (current.value!= ' ') {
            word += current.value;
        }
        longestCommonPrefix(current.getChildren()[0],word, longestPrefix);
    }

    public boolean Contains(String word){
        return Contains(root, word, 0);
    }
    private boolean Contains(Node root, String word, int index){
        if (index == word.length()){
            return root.isEndOfWord;
        }
        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child==null)
            return false;
        return Contains(child, word, index+1);
    }
}
