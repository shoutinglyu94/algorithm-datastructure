package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PostorderTraversal implements TreeTraverse{

    @Override
    public void traverseRecursively(TreeNode root, List<Integer> res) {
        if(root == null) return;
        traverseRecursively(root.left, res);
        traverseRecursively(root.right, res);
        res.add(root.val);
    }

    @Override
    public void traverseIterativelyWithStack(TreeNode root, List<Integer> res) {
        if(root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if((pre == null || pre.left == cur || pre.right == cur) && cur.left != null) {
                stack.push(cur.left);
            } else if (pre == cur.left && cur.right != null) {
                stack.push(cur.right);
            } else {
                stack.poll();
                res.add(cur.val);
            }
            pre = cur;
        }
    }

    @Override
    public void traverseIterativelyWithParent(TreeNode root, List<Integer> res) {
        TreeNode cur = firstNodeRecursively(root);
        while(cur != null) {
            res.add(cur.val);
            cur = nextNode(cur);
        }
    }

    private TreeNode firstNode(TreeNode cur) {
        if(cur == null) return null;
        while(cur.left != null || cur.right != null) {
            if(cur.left != null) cur = cur.left;
            else if(cur.right != null) cur = cur.right;
        }
        return cur;
    }

    private TreeNode firstNodeRecursively(TreeNode cur) {
        if(cur == null) return null;
        if(cur.left != null) return firstNode(cur.left);
        else if(cur.right != null) return firstNode(cur.right);
        return cur;
    }


    private TreeNode nextNode(TreeNode cur) {
        if(cur == null) return null;
        if(cur.parent == null) {
            return null;
        }
        if(cur == cur.parent.left && cur.parent.right != null) {
            return firstNode(cur.parent.right);
        }
        return cur.parent;
    }
}
