package leetcode.editor.cn;

import leetcode.bfs.TreeNode;

/**
 * 6/12/22 07:45
 * aiguoxin 树的处理，深度搜索用堆栈递归，广度搜索则用队列
 * 说明: https://leetcode.cn/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/
 */
public class SumOfLeftLeaf {
    static int sum = 0;

    public static int sumOfLeftLeaves(TreeNode root) {

        sum = add(root);
        return sum;
    }

    private static int add(TreeNode node) {
        if (node != null && node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum = add(node.left) + node.left.val;
            }else{
                sum = add(node.left);
            }
        }
        if (node != null && node.right != null) {
            sum = add(node.right);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n9 = new TreeNode(2);
        TreeNode n20 = new TreeNode(3);
        TreeNode n15 = new TreeNode(4);
        TreeNode n7 = new TreeNode(5);

        root.left = n9;
        root.right = n20;
        n9.left = n15;
        n9.right = n7;

        System.out.println(sumOfLeftLeaves(root));
    }

}
