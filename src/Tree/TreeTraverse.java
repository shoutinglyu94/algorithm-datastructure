package Tree;

import java.util.List;

public interface TreeTraverse {

    public void traverseRecursively(TreeNode root, List<Integer> res);

    public void traverseIterativelyWithStack(TreeNode root, List<Integer> res);

    public void traverseIterativelyWithParent(TreeNode root, List<Integer> res);
}
