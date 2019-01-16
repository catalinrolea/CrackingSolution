package trees;

import org.junit.Test;

/*
Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree
 */
// https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
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

    public void insertStandard(int key) {
        root = insertRecursively(root, key);
    }

    TreeNode insertRecursively(TreeNode node, int key) {
        if (node == null) {
            node = new TreeNode(key);
            return node;
        }
        TreeNode temp = null;

        if (key < node.key) {
            temp = insertRecursively(node.left, key);
            node.left = temp;
            temp.parent = node;
        } else if (key > node.key) {
            temp = insertRecursively(node.right, key);
            node.right = temp;
            temp.parent = node;
        }
        return node;
    }

    public void printInorder(TreeNode node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    TreeNode findNextNodeInorderSuccessor(TreeNode node, TreeNode myNode)   {
        //if right subtree is not NULL, get latest left node from right subtree
        if (myNode.right != null)   {
            returnMinValueForRightSubtree(myNode.right);
        }

        //if right subtree is null, get the parent of the right node
        //if the left node is leaf => return parent
        //if right node is leaf=> set myNode to parent
        TreeNode parentNode = myNode.parent;
        while (parentNode != null && parentNode.right == myNode)    {
            myNode = parentNode;
            parentNode = parentNode.parent;
        }
        System.out.print(parentNode.key);
        return parentNode;
    }

    TreeNode returnMinValueForRightSubtree(TreeNode node)   {
        TreeNode current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;

    }


    @Test
    public void workSuccessorNextNode() {
        SuccessorNextNode tree = new SuccessorNextNode();
        tree.insertStandard(8);
        tree.insertStandard(4);
        tree.insertStandard(10);
        tree.insertStandard(2);
        tree.insertStandard(6);
        tree.insertStandard(9);
        tree.insertStandard(20);

        tree.printInorder(tree.root);

        System.out.println("-------------------");
        tree.findNextNodeInorderSuccessor(tree.root,tree.root.left.left);

    }
}
