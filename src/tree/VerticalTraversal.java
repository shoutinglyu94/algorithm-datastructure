package tree;

import java.util.ArrayList;
import java.util.List;

public class VerticalTraversal {
    int min = 0, max = 0;
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int i, List<List<Integer>> res) {
        if(root == null) return;
        if(i < min) {
            res.add(0, new ArrayList<>());
            min = i;
        } else if(i > max) {
            res.add(new ArrayList<>());
            max = i;
        }
        res.get(i - min).add(root.val);
        dfs(root.left, i - 1,  res);
        dfs(root.right, i + 1, res);
    }
}
