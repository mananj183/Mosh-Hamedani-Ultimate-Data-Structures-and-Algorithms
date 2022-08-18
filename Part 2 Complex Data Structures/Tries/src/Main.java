public class Main {
    public static void main(String[] args){

        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("canada");
        trie.insert("play");
        trie.insert("car");
        trie.insert("cared");
        trie.insert("care");
        trie.insert("cares");
        trie.insert("careful");
        trie.insert("catapult");
        System.out.println(trie.Contains(" "));
//        trie.autoComplete("p");
//        trie.removeWord("catapult");
//        System.out.println(trie.longestCommonPrefix(new String[]{"car","card"}));
//        trie.autoComplete("c");
//        System.out.println(trie.countWords());
//        System.out.println(trie.contains("cat"));
//        System.out.println(trie.contains("catapult"));
        System.out.println();
    }
}
