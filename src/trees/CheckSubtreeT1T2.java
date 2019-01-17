package trees;

import org.junit.Test;

/*@
   Given T1, T2 very large binary trees(T1 larger then T2), check if T2 is a subtree of T2
 */
// https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
public class CheckSubtreeT1T2 {

    class TreeNode {
        private int key;
        TreeNode left, parent, right;

        public TreeNode(int key) {
            this.key = key;
            left = parent = right = null;
        }
    }

    TreeNode root;

    public CheckSubtreeT1T2() {
        root = null;
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null)
            return;
        inorderTraversal(node.left);
        System.out.print(node.key + " ");
        inorderTraversal(node.right);
    }

    public void preorderTraversal(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.key + " ");
        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }

    boolean checkSubTreesAreIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if ((root1.key == root2.key) && checkSubTreesAreIdentical(root1.left, root2.left) && checkSubTreesAreIdentical(root1.right, root2.right))
            return true;
        return false;
    }

    boolean isT2SubtreeOfT1(TreeNode largerTreeRoot, TreeNode smallerTreeRoot) {
        //means the larger tree has it's leaf 0 while smaller tree still have leaf>1
        if (largerTreeRoot == null)
            return false;
        if (smallerTreeRoot == null)
            return true;
        boolean flag = false;

        if (largerTreeRoot.key == smallerTreeRoot.key)
            return checkSubTreesAreIdentical(largerTreeRoot, smallerTreeRoot);
        return isT2SubtreeOfT1(largerTreeRoot.left,smallerTreeRoot) || isT2SubtreeOfT1(largerTreeRoot.right,smallerTreeRoot);
    }

    @Test
    public void checkSubtreeInTree() {


        CheckSubtreeT1T2 largerTree = new CheckSubtreeT1T2();
        largerTree.root = new TreeNode(26);
        largerTree.root.left = new TreeNode(10);
        largerTree.root.right = new TreeNode(3);
        largerTree.root.left.left = new TreeNode(4);
        largerTree.root.left.right = new TreeNode(6);
        largerTree.root.left.left.right = new TreeNode(30);

        CheckSubtreeT1T2 smallerTree = new CheckSubtreeT1T2();
        smallerTree.root = new TreeNode(10);
        smallerTree.root.left = new TreeNode(4);
        smallerTree.root.right = new TreeNode(6);
        smallerTree.root.left.right = new TreeNode(30);

        inorderTraversal(smallerTree.root);
        System.out.println("");
        preorderTraversal(smallerTree.root);
        System.out.println("");
        //System.out.print(checkSubTreesAreIdentical(largerTree.root,smallerTree.root));
         if (isT2SubtreeOfT1(largerTree.root, smallerTree.root)) {
             System.out.println("Smaleer (LEFT) tree is part of larger tree");
         } else
         {
             System.out.println("Smaleer (LEFT) tree is NOT part of larger tree");
         }

        System.out.println();
        // *** Second example-> subtree on the right ***

        CheckSubtreeT1T2 mare = new CheckSubtreeT1T2();
        mare.root = new TreeNode(26);
        mare.root.left = new TreeNode(3);
        mare.root.right = new TreeNode(10);
        mare.root.right.left = new TreeNode(4);
        mare.root.right.right = new TreeNode(5);

        CheckSubtreeT1T2 mic = new CheckSubtreeT1T2();
        mic.root = new TreeNode(10);
        mic.root.left = new TreeNode(4);
        mic.root.right = new TreeNode(5);
        if (isT2SubtreeOfT1(mare.root, mic.root)) {
            System.out.println("Smaleer (RIGHT) tree is part of larger tree");
        } else
        {
            System.out.println("Smaleer RIGHT) tree is NOT part of larger tree");
        }
    }

}
