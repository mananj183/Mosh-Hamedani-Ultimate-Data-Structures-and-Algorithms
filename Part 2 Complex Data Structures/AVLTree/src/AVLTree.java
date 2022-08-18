public class AVLTree {
    private class AVLNode{
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height = 0;
        public AVLNode(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "Value= " + this.value + " and height= " + this.height;
        }
    }
    private AVLNode root;
    public void insert(int value){
        root = insert(root, value);
    }
    private AVLNode insert(AVLNode root, int value){
        if (root == null) {
            return new AVLNode(value);
        }
        if (root.value > value){
            root.leftChild = insert(root.leftChild, value);
        } else if (root.value < value) {
            root.rightChild = insert(root.rightChild, value);
        }
        setHeight(root);
        root = balance(root);
        return root;
    }

    private AVLNode balance(AVLNode root){
        int balanceFactor = balanceFactor(root);
        if (isLeftHeavy(balanceFactor)) {
            if (balanceFactor(root.leftChild) == 1) {
                root = rightRotation(root);
            } else if (balanceFactor(root.leftChild) == -1) {
                root.leftChild = leftRotation(root.leftChild);
                root = rightRotation(root);
            }
        }
        else if (isRightHeavy(balanceFactor)) {
            if (balanceFactor(root.rightChild) == -1) {
                root = leftRotation(root);
            } else if (balanceFactor(root.leftChild) == 1) {
                root.rightChild = rightRotation(root.rightChild);
                root = leftRotation(root);
            }
        }
        return root;
    }
    private int height(AVLNode node){
        return (node == null) ? -1 : node.height;
    }
    private int balanceFactor(AVLNode node){
        return height(node.leftChild) - height(node.rightChild);
    }
    private boolean isLeftHeavy(int balanceFactor){
        return balanceFactor > 1;
    }
    private boolean isRightHeavy(int balanceFactor){
        return balanceFactor < -1;
    }
    private AVLNode leftRotation(AVLNode root){
        AVLNode node = root.rightChild;
        root.rightChild = node.leftChild;
        node.leftChild = root;
        setHeight(root);
        setHeight(node);
        return node;
    }
    private void setHeight(AVLNode node){
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }
    private AVLNode rightRotation(AVLNode root){
        AVLNode node = root.leftChild;
        root.leftChild = node.rightChild;
        node.rightChild = root;
        setHeight(root);
        setHeight(node);
        return node;
    }
}


/*
    10    balanceFactor(10) < -1 --> right heavy
        20   we check balance factor of 10.rightChild --> balanceFactor(20) = -1 therefore imbalance due to right child right subtree
            30
    therefore we perform --> leftRotation(10)

-------------------------------------------------------------------------------------------------------------------------------------
    10   balanceFactor(10) < -1 --> right Heavy
        30   we check balance factor of 10.rightChild --> balanceFactor(30) = 1 therefore imbalance due to right child left subtree
    20
    therefore we perform --> rightRotation(30) which gives

    10
        20
            30
    now we perform leftRotation(10)

-------------------------------------------------------------------------------------------------------------------------------------
            30  balanceFactor(30) > 1 --> left heavy
        20   we check balance factor of 30.leftChild --> balanceFactor(20) = 1 therefore imbalance due to left child left subtree
    10
    rightRotation(30)

-------------------------------------------------------------------------------------------------------------------------------------
        30     balanceFactor(30) > 1 --> left Heavy
    10       we check balance factor of 30.leftChild --> balanceFactor(10) = -1 therefore imbalance due to left child right subtree
        20
    leftRotation(10)

            30
        20
    10
    rightRotation(30)
*/