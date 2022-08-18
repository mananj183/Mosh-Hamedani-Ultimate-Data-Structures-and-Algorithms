import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    public static class Node{
        int value;
        Node leftChild;
        Node rightChild;
        public Node(int value){
            this.value = value;
        }
    }

    private Node root;
    public BinarySearchTree(Node root){
        this.root = root;
    }
    public void insert(int value){
        Node current = root;
        while (current != null) {
            if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = new Node(value);
                    return;
                }
                current = current.rightChild;
            }else if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = new Node(value);
                    return;
                }
                current = current.leftChild;
            }else {
                current = null;
            }
        }
    }

    public boolean find(int value){
        Node current = root;
        while (current != null) {
            if (value > current.value) {
                current = current.rightChild;
            }else if (value < current.value){
                current = current.leftChild;
            }else if (value == current.value){
               return true;
            }
        }
        return false;
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    public void swapNodes(){
        Node temp = root.rightChild;
        root.rightChild = root.leftChild;
        root.leftChild = temp;
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void preOrderTraversal(Node root){
        if (root == null)
            return;
        System.out.println(root.value);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }
    private void inOrderTraversal(Node root){
        if (root == null)
            return;
        inOrderTraversal(root.leftChild);
        System.out.println(root.value);
        inOrderTraversal(root.rightChild);
    }
    private void postOrderTraversal(Node root){
        if (root == null)
            return;
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.value);
    }

    public int height(){
        return height(root);
    }
    public int min() { return min(root); }

    private int height(Node root){
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private int min(Node root){
        int left = root.value;
        int right = root.value;
        if (isLeaf(root))
            return root.value;
        else if (root.rightChild == null)
            left = min(root.leftChild);
        else if (root.leftChild == null)
            right = min(root.rightChild);
        else {
            left = min(root.leftChild);
            right = min(root.rightChild);
        }

        return Math.min(Math.min(left,right),root.value);
    }
    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean equals(BinarySearchTree tree){
        return equals(root, tree.root);
    }

    private boolean equals(Node first, Node second){
        if (first == null && second == null)
            return true;
        if (first != null && second != null)
            return first.value== second.value && equals(first.leftChild,second.leftChild) && equals(first.rightChild, second.rightChild);
        return false;
    }
    public boolean validateBST(){
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBST(Node root, int leftLimit, int rightLimit){
        if (root == null)
            return true;
        return root.value > leftLimit && root.value < rightLimit && validateBST(root.leftChild, leftLimit, root.value) && validateBST(root.rightChild, root.value, rightLimit);
    }

    public List<Integer> NodesAtDistance(int k){
        List<Integer> list = new ArrayList<>();
        NodesAtDistance(root,k, list);
        return list;
    }
    private void NodesAtDistance(Node root, int k, List<Integer> list){
        if (root==null)
            return;
        if (k==0){
            System.out.println(root.value);
//            list.add(root.value);
            return;
        }
        NodesAtDistance(root.leftChild, k-1, list);
        NodesAtDistance(root.rightChild, k-1, list);
    }

    public void depthFirstSearchTraversal(){
        for (int i = 0; i<=height(); i++){
            NodesAtDistance(i);
        }
    }

    public int size(){
        return size(root);
    }
    private int size(Node root){
        if (root == null)
            return 0;
        return 1 + size(root.leftChild) + size(root.rightChild);
    }
    public int countLeaves(){
        return countLeaves(root);
    }
    private int countLeaves(Node root){
        if (root==null)
            return 0;
        if (isLeaf(root))
            return 1;
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max(){
        return max(root);
    }

    private int max(Node root){
        if (root == null)
            return 0;
        if (isLeaf(root))
            return root.value;
        return max(root.rightChild);
    }

    public boolean contains(int value){
        return contains(root, value);
    }
    private boolean contains(Node root, int value){
        if (root==null)
            return false;
        if (root.value == value)
            return true;
        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    public boolean areSiblings(int v1, int v2){
        return areSiblings(root, null, v1, v2);
    }
    private boolean areSiblings(Node root, Node previous, int v1, int v2){
        if (root == null )
            return false;
        if (root.value == v1 || root.value == v2){
            if (previous != null && previous.leftChild != null && previous.rightChild != null )
                return (previous.leftChild.value == v1 && previous.rightChild.value == v2) || (previous.leftChild.value == v2 && previous.rightChild.value == v1);
            return false;

        }
        return areSiblings(root.leftChild, root, v1, v2) || areSiblings(root.rightChild, root, v1, v2);
    }

    public void getAncestors(int v){
        getAncestors(root, v);
    }
    private boolean getAncestors(Node root, int v){
        if (root==null)
            return false;
        if (root.value == v){
            return true;
        }
        if (getAncestors(root.leftChild,v) || getAncestors(root.rightChild, v)){
            System.out.println(root.value);
            return true;
        }
        return false;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node root){
        if (root == null)
            return true;
        return  mod(height(root.leftChild) - height(root.rightChild)) <= 1 && isBalanced(root.rightChild) && isBalanced(root.leftChild);
    }

    private int mod(int n){
        return n>=0 ? n : -1*n;
    }
    public boolean isPerfect(){
        return isPerfect(root);
    }
    private boolean isPerfect(Node root){
        if (root == null)
            return true;
        int limit = (int) Math.pow(2,height(root));
        for (int i = limit; i<2*limit; i++){
            if (size(root) == i)
                return true;
        }
        return false;
    }
}
