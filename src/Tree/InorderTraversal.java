package Tree;

import java.util.List;

public class InorderTraversal {
    // Recursion
    public static void InorderRecursion(TreeNode root, List<Integer> res) {
        if(root == null) return;
        InorderRecursion(root.left, res);
        res.add(root.val);
        InorderRecursion(root.right, res);
    }




}
