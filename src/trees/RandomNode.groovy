package trees

import org.junit.Test
import sun.reflect.generics.tree.Tree

import javax.swing.tree.TreeNode

class RandomNode {

    class TreeNode {
        int key;
        TreeNode left, right, parent;
        public TreeNode(int key)    {
            this.key = key;
            left = right = parent = null;
        }
    }
    TreeNode root = null;
    TreeNode searchedNode = null;
    public RandomNode() {
        root = searchedNode = null;
    }

    void INSERTStandard(int key) {
        root = insertRecursively(root, key);
    }
    TreeNode insertRecursively(TreeNode node, int key)  {
        if (node == null) {
            node = new TreeNode(key);
            return node;
        }

        TreeNode tempNode = null;
        if (key < node.key) {
            tempNode = insertRecursively(node.left,key)
            node.left = tempNode;
            tempNode.parent = node;
        }
        if (key > node.key) {
            tempNode = insertRecursively(node.right,key)
            node.right = tempNode;
            tempNode.parent = node;
        }
        return node;
    }

    TreeNode FINDNode(TreeNode node, int key) {
        //Search the node in preorder traversal
        if (node == null)
            return null;

        if (key == node.key)
            searchedNode = new TreeNode(key);

        if (key < node.key) {
            FINDNode(node.left);

            if (key > node.key) {
                FINDNode(node.right);
            }

            return searchedNode;
        }
     }

    TreeNode deleteNode3WaysRec(TreeNode node, int key) {

        if (node == null)
            return null
        if (key < node.key)
            node.left = deleteNode3WaysRec(node.left,key)
        else if (key > node.key)
            node.right = deleteNode3WaysRec(node.right,key)
         else {
            //case 1: node is lead
            //case 2: node has 1 child
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            //case 3: node with two children:
                // - get inorder successor(element on the last level
            node.key = minValueSubtree(node.right); // set root key to be the last value of the right subtree fom key deleted
            node.right = deleteNode3WaysRec(node.right, node.key);

        }

        return node;

    }

    int minValueSubtree(TreeNode node)  {
        int min = node.key;
        while (node.left != null)   {
            min = node.left.key;
            node = node.left
        }
        return min;
    }

    void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);
        print(node.key + " ");
        inorder(node.right);
    }

    @Test
    void randomNode()   {
        println("Random node --- search, find, insert, delete ---")
        println()
        RandomNode treeNode = new RandomNode();
        treeNode.INSERTStandard(20);
        treeNode.INSERTStandard(10);
        treeNode.INSERTStandard(30);
        treeNode.INSERTStandard(15);
        treeNode.INSERTStandard(17);
        treeNode.INSERTStandard(5);
        treeNode.INSERTStandard(3);
        treeNode.INSERTStandard(7);
        treeNode.inorder(treeNode.root);
        System.out.println();

        treeNode.deleteNode3WaysRec(treeNode.root,5)
        treeNode.inorder(treeNode.root);
    }
}
