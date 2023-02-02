package leetcode.tree;

import leetcode.bfs.TreeNode;
import org.junit.Test;

/**
 * 2/2/23 18:37
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/univalued-binary-tree/
 */
public class UnivaluedTree {
    int value = -1;
    boolean flag = true;

    public boolean isUnivalTree(TreeNode root) {
        value = root.val;

        find(root);

        return flag;
    }

    private void find(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val != value) {
            flag = false;
            return;
        }

        find(root.left);
        find(root.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        root.left = n1;
        root.right = n2;
        System.out.println(isUnivalTree(root));
    }

}
