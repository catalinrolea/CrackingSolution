package trees;

public class ValidateBST {
    static class TreeNode {
        int key;
        TreeNode parent, left, right;

        public TreeNode(int key) {
            this.key = key;
            parent = left = right = null;
        }
    }

    TreeNode root;

    public ValidateBST() {
        root = null;
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.key + " ");
        inorderTraversal(node.right);
    }

    boolean checkBinarySearchTree(TreeNode node) {
        if (node == null)
            return true;

        int left = getHeightsLeft(node.left);
        int right = getHeightsRight(node.right);
        if (left == right && checkChildren(node) == 0)
            return true;
        return false;
    }

    int getHeightsLeft(TreeNode node) {
        if (node == null)
            return 0;

        if (node.key > root.key) {
            return node.key;
        }

        return Math.max(getHeightsLeft(node.left), getHeightsLeft(node.right));
    }

    int getHeightsRight(TreeNode node) {
        if (node == null)
            return 0;

        if (node.key < root.key) {
            return node.key;
        }
        return Math.max(getHeightsRight(node.left), getHeightsRight(node.right));
    }

    int checkChildren(TreeNode node) {
        if (node == null)
            return 0;
        if ((node.left != null && node.right == null) || (node.left == null && node.right != null))   {
            return node.key;
        }

        return Math.max(checkChildren(node.left), checkChildren(node.right));
    }

    public static void main(String[] args) {
        ValidateBST tree = new ValidateBST();

        tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(6);
        //if add node 1 => binary tree
        tree.root.left.left.left = new TreeNode(1);

        tree.root.right.left = new TreeNode(9);
        tree.root.right.right = new TreeNode(20);
        tree.root.right.right.right = new TreeNode(30);


        tree.inorderTraversal(tree.root);
        System.out.println();
        if (tree.checkBinarySearchTree(tree.root))
            System.out.println("This is a binary search tree");
        else
            System.out.println("This is a binary tree");
        System.out.println();
        //System.out.print(tree.checkChildren(tree.root) + " ");

    }
}
