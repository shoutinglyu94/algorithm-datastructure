package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal implements TreeTraverse {
    @Override
    public void traverseRecursively(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        traverseRecursively(root.left, res);
        traverseRecursively(root.right, res);
    }

    @Override
    public void traverseIterativelyWithStack(TreeNode root, List<Integer> res) {
        if(root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.poll();
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
            res.add(cur.val);
        }
    }

    @Override
    public void traverseIterativelyWithParent(TreeNode root, List<Integer> res) {
        TreeNode cur = root;
        while(cur != null) {
            res.add(cur.val);
            cur = nextNode(cur);
        }
    }

    private TreeNode nextNode(TreeNode cur) {
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
}
