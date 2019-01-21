package trees;
/*
https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 */
public class CheckBalancedTree {
    TreeNode root;

    static class TreeNode {
        int key;
        TreeNode parent, left, right;

        public TreeNode(int key) {
            this.key = key;
            parent = left = right = null;
        }
    }

    public CheckBalancedTree() {
        root = null;
    }


    public void insertStandard(int key) {
        root = insertRecursivelyStandard(root, key);
    }

    TreeNode insertRecursivelyStandard(TreeNode node, int key) {
        if (node == null) {
            node = new TreeNode(key);
            return node;
        }
        if (key < node.key)
            node.left = insertRecursivelyStandard(node.left, key);
        if (key > node.key)
            node.right = insertRecursivelyStandard(node.right, key);
        return node;
    }

    int countHeightsOfTree(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(countHeightsOfTree(root.left), countHeightsOfTree(root.right));
    }

    boolean isTreeBalanced(TreeNode root)   {
        if (root == null)
            return true;
        int leftHeight, rightHeight;
        leftHeight = countHeightsOfTree(root.left);
        rightHeight = countHeightsOfTree(root.right);
        System.out.println("l: "+leftHeight);        System.out.println();
        int diff = leftHeight-rightHeight;
        System.out.println("r: "+rightHeight);

        //
        if (diff <=1 && isTreeBalanced(root.left) && isTreeBalanced(root.right))
            return true;
        return false;
    }

    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(" " + node.key);
            inorderTraversal(node.right);
        }

    }


    public static void main(String[] args) {
        CheckBalancedTree tree = new CheckBalancedTree();
        //example for unbalanced tree
        /*tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.left.left = new TreeNode(8);*/

        //example for balanced tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);
        tree.root.left.left.left = new TreeNode(7);

        tree.inorderTraversal(tree.root);
        System.out.println("");

        if (tree.isTreeBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is unbalanced");
    }
}
