public class Main {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree(new BinarySearchTree.Node(40));
        tree.insert(30);
        tree.insert(50);
        tree.insert(20);
//        tree.insert(35);
        tree.insert(45);
//        tree.insert(60);
//        tree.insert(7);
//        tree.insert(22);
        System.out.println(tree.isPerfect());
//        System.out.println(tree.height());
//        tree.getAncestors(22);
//        System.out.println(tree.areSiblings(10,30));
//        System.out.println(tree.contains(12));
//        System.out.println(tree.max());
//        System.out.println(tree.size());
//        System.out.println(tree.countLeaves());
//        tree.depthFirstSearchTraversal();
//        System.out.println(tree.NodesAtDistance(3));
//        tree.swapNodes();
//        System.out.println(tree.validateBST());
//        BinarySearchTree tree2 = new BinarySearchTree(new BinarySearchTree.Node(3));
//        tree2.insert(4);
//        tree2.insert(9);
//        tree2.insert(7);
//        tree2.insert(6);
//        tree2.insert(2);
//        tree2.insert(10);
//        tree2.insert(15);
//        System.out.println(tree.equals(tree2));
//        System.out.println(tree.min());
//        tree.postOrderTraversal();
//        System.out.println(tree.find(15));


//        System.out.println(factorial(3));
    }

    public static void get_bits(int length, String b){
        String part1 = "abcdefgh";
        String part2 = "ijklmnop";
        if (b.charAt(0) == '0'){
            int part1_len = part1.length();
            if (b.charAt(1) == '0'){
                part1_len -= length;
                if (b.charAt(2) == '0'){
                    part1_len -= (length/2);
                    if (b.charAt(3) == '1'){
                        System.out.println(part1.charAt(1));
                    }
                    else System.out.println(part1.charAt(0));
                }
            }
        }
    }
    public static int getAscii(String s){
        int ascii = 0;
        for (int i: s.toCharArray())
            ascii+= i;
        return ascii;
    }
    // Recursion Practice
    public static int factorial(int n){
        if (n == 1)
            return 1;
        return n * factorial(n-1);
    }
}
