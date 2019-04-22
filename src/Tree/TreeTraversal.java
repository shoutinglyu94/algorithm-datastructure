package Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {
    /*
                1
               / \
              2   3
             / \
            4   5
               / \
              6   7

     */
    public static void main(String[] args) {
        TreeNode root = buildExampleTree();
        inorderTraversal(root);
        preorderTraversal(root);
    }

    private static void preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        PreorderTraversal.preOrderIterativeWithParent(root, preOrder);
        for(int i : preOrder) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
    private static void inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        InorderTraversal.InorderRecursion(root, inorder);
        for(int i : inorder) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    private static TreeNode buildExampleTree() {
        TreeNode[] nodes = new TreeNode[7];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i + 1);
        }
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].parent  = nodes[0];
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].parent  = nodes[0];

        nodes[3].parent  = nodes[1];

        nodes[4].parent  = nodes[1];
        nodes[4].left = nodes[5];
        nodes[4].right = nodes[6];

        nodes[5].parent = nodes[4];
        nodes[6].parent = nodes[4];

        return nodes[0];
    }
}
