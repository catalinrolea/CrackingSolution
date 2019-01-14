package trees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
ex: if you ahve D depths, you will have D linked list
 */
public class ListOfDepthsOfBinaryTree {
    class TreeNode  {
        int key;
        private TreeNode left, parent, right;
        public TreeNode(int key)   {
            this.key = key;
            this.left = this.parent = this.right = null;
        }
    }

    public TreeNode root;
    public ListOfDepthsOfBinaryTree()   {
        root = null;
    }

    public void insertStandardRecursivelyTree(int key)   {
        root = insertNodeRecursively(root, key);
    }

    TreeNode insertNodeRecursively(TreeNode node, int key)  {
        if (node == null)   {
            node = new TreeNode(key);
            return node;
        }

        if (key < node.key)
            node.left = insertNodeRecursively(node.left,key);
        if (key > node.key)
            node.right = insertNodeRecursively(node.right, key);
        return node;
    }

    public void inorderTraversal(TreeNode node) {
        if (node!=null) {
            inorderTraversal(node.left);
            System.out.print(" "+node.key);
            inorderTraversal(node.right);
        }
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root)    {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> listsOfNodes = new LinkedList<>();
        if (root != null)   {
            listsOfNodes.add(root);
        }
        while (listsOfNodes.size() != 0)    {
            result.add(listsOfNodes);
            LinkedList<TreeNode> parentsNodes = listsOfNodes;
            listsOfNodes = new LinkedList<>();
            for (TreeNode parent : parentsNodes)    {
                if (parent.left != null)    {
                    listsOfNodes.add(parent.left);
                }
                if (parent.right != null)   {
                    listsOfNodes.add(parent.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args)  {
        ListOfDepthsOfBinaryTree binaryTree = new ListOfDepthsOfBinaryTree();
        binaryTree.insertStandardRecursivelyTree(5);
        binaryTree.insertStandardRecursivelyTree(2);
        binaryTree.insertStandardRecursivelyTree(7);
        binaryTree.inorderTraversal(binaryTree.root);
        binaryTree.createLevelLinkedList(binaryTree.root);
        System.out.println("");
        for (int index=0; index< binaryTree.createLevelLinkedList(binaryTree.root).size(); index++)    {
            System.out.println("level " + index +" containing: "+binaryTree.createLevelLinkedList(binaryTree.root).get(index).size()+" lists(s)");
        }
    }

}
