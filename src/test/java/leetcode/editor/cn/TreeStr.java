package leetcode.editor.cn;

import leetcode.bfs.TreeNode;

/**
 * 7/27/22 22:20
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/construct-string-from-binary-tree/submissions/
 */
public class TreeStr {

    public static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
        }
        if (root.left == null) {
            return new StringBuilder().append(root.val).append("()").append("(").append(tree2str(root.right)).append(
                    ")").toString();
        }

        return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(")
                .append(tree2str(root.right)).append(")").toString();
    }

    public static void main(String[] args) {

    }
}
