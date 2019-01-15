package trees;

import org.junit.Test;

/*
Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree
 */
public class SuccessorNextNode {

    class TreeNode {
        private int key;
        TreeNode left, parent, right;

        public TreeNode(int key) {
            this.key = key;
            left = parent = right = null;
        }
    }

    TreeNode root;

    public SuccessorNextNode() {
        root = null;
    }

    public void printInorder(TreeNode node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    public TreeNode returnLeftNode(TreeNode node) {
        if (node == null)
            return null;

        System.out.print(node.key + " ");
        node.left = returnLeftNode(node.left);
        return node;
    }

    public int searchNode(TreeNode node, int searchKey) {
        if (node == null)
            return 0;


        return 0;
    }

    @Test
    public void workSuccessorNextNode() {
        System.out.println("Work out successor next node- from git");
        SuccessorNextNode tree = new SuccessorNextNode();
        tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(4);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(6);
        tree.root.right = new TreeNode(10);
        tree.root.right.left = new TreeNode(9);
        tree.printInorder(tree.root);
        System.out.println("-------------------");
        searchNode(tree.root, 4);
    }
}
