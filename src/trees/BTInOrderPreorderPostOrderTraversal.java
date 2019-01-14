package trees;

public class BTInOrderPreorderPostOrderTraversal {

    class TreeNode {
        int key;
        TreeNode parent, left, right;

        public TreeNode(int key) {
            this.key = key;
            parent = left = right = null;
        }
    }

    public TreeNode root;

    public BTInOrderPreorderPostOrderTraversal() {
        root = null;
    }

    public void insertStandardRec(int key) {
        root = insertNodeRecursively(root, key);
    }

    TreeNode insertNodeRecursively(TreeNode node, int key) {
        if (node == null) {
            node = new TreeNode(key);
            return node;
        }
        if (key < node.key)
            node.left = insertNodeRecursively(node.left, key);
        else if (key > node.key)
            node.right = insertNodeRecursively(node.right, key);
        return node;
    }

    // **************** Traversal Node ********************************
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }



    public static void main(String[] args) {
        BTInOrderPreorderPostOrderTraversal binarySearchTree = new BTInOrderPreorderPostOrderTraversal();
        binarySearchTree.insertStandardRec(8);
        binarySearchTree.insertStandardRec(4);
        binarySearchTree.insertStandardRec(10);
        System.out.print("Inorder:   ");
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        System.out.print("PreOrder:  ");
        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println();
        System.out.print("PostOrder: ");
        binarySearchTree.postOrder(binarySearchTree.root);
    }
}
