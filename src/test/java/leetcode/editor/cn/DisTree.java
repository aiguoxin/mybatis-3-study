package leetcode.editor.cn;

import leetcode.bfs.TreeNode;

/**
 * 7/5/22 22:03
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/diameter-of-binary-tree/
 */
public class DisTree {
    int maxd = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        /**
         * 没想到这个！！！
         */
        maxd = Math.max(Left + Right, maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left, Right) + 1;//返回节点深度
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        DisTree disTree = new DisTree();
        System.out.println(disTree.diameterOfBinaryTree(root));
    }
}
