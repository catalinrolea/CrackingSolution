package trees;

import org.junit.Test;

/**
 * https://cs.stackexchange.com/questions/83540/how-to-select-a-binary-tree-node-uniformly-at-random
 */
public class RandomNode {

    class TreeNode {
        private int key;
        private TreeNode left, right, parent;

        TreeNode(int key) {
            this.key = key;
            this.left = this.right = this.parent = null;
        }
    }

    TreeNode root;

    public RandomNode() {
        root = null;
    }

    void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    public void insertStandard(int key) {
        root = insertRecursivelyBinaryTree(root, key);
    }

    TreeNode insertRecursivelyBinaryTree(TreeNode node, int key) {
        if (node == null) {
            node = new TreeNode(key);
            return node;
        }
        TreeNode temporaryNode = null;
        if (key < node.key) {
            temporaryNode = insertRecursivelyBinaryTree(node.left,key);
             node.left = temporaryNode;
             temporaryNode.parent = node;
        }
        if (key > node.key) {
            temporaryNode = insertRecursivelyBinaryTree(node.right,key);
            node.right = temporaryNode;
            temporaryNode.parent = node;
        }
        return node;
    }

    TreeNode findNode(TreeNode node, int key) {

        if (node == null)
            return null;



        return node;
    }

    @Test
    public void randomNode() {
        System.out.println("Work in progress...get random node from a binary tree");
        RandomNode treeNode = new RandomNode();
        treeNode.insertStandard(20);
        treeNode.insertStandard(10);
        treeNode.insertStandard(30);
        treeNode.insertStandard(15);
        treeNode.insertStandard(17);
        treeNode.insertStandard(5);
        treeNode.insertStandard(3);
        treeNode.insertStandard(7);
      //  treeNode.inorder(treeNode.root);

        System.out.println(treeNode.findNode(treeNode.root,10));
    }
}
