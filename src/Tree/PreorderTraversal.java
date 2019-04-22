package Tree;

import java.util.List;

public class PreorderTraversal {

    public static void preOrderIterativeWithParent(TreeNode root, List<Integer> res) {
        TreeNode cur = root;
        while(cur != null) {
            res.add(cur.val);
            cur = nextNode(cur);
        }
    }
    // with parent pointer
    public static TreeNode nextNode(TreeNode cur) {
        if(cur.left != null) {
            return cur.left;
        }
        if(cur.right != null) {
            return cur.right;
        }

        while(cur.parent != null && (cur == cur.parent.right || cur.parent.right == null)) {
            cur = cur.parent;
        }
        if(cur.parent == null) {
            return null;
        }
        return cur.parent.right;
    }

    public static void preorderRecursion(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        preorderRecursion(root.left, res);
        preorderRecursion(root.right, res);
    }

}
