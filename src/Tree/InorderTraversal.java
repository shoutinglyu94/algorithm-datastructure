package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class InorderTraversal implements TreeTraverse {

    @Override
    public void traverseRecursively(TreeNode root, List<Integer> res) {
        if (root == null) return;
        traverseRecursively(root.left, res);
        res.add(root.val);
        traverseRecursively(root.right, res);
    }

    @Override
    public void traverseIterativelyWithStack(TreeNode root, List<Integer> res) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        firstNode(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            firstNode(cur.right, stack);
        }
    }

    private void firstNode(TreeNode cur, Deque<TreeNode> stack) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    @Override
    public void traverseIterativelyWithParent(TreeNode root, List<Integer> res) {
        if (root == null) return;
        TreeNode cur = firstNode(root);
        while (cur != null) {
            res.add(cur.val);
            cur = nextNode(cur);
        }
    }

    private TreeNode nextNode(TreeNode cur) {
        if (cur.right != null) {
            return firstNode(cur.right);
        }
        while (cur.parent != null && cur == cur.parent.right) {
            cur = cur.parent;
        }
        return cur.parent;
    }

    private TreeNode firstNode(TreeNode cur) {
        if (cur == null) return null;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}
