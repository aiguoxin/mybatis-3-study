package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2022/1/14 下午8:44
 * aiguoxin
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点
 * 说明: 找出二叉树最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class TreeMinDepth {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 0;

        Queue<TreeNode> p = new LinkedList<>();
        p.add(root);
        while(!p.isEmpty()){
            minDepth ++;
            int queueSize = p.size();
            while (queueSize > 0) {
                TreeNode cur = p.poll();
                if (cur.right == null && cur.left == null) {
                    return minDepth ++;
                }
                if (cur.left != null) {
                    p.add(cur.left);
                }
                if (cur.right != null) {
                    p.add(cur.right);
                }
                queueSize --;
            }
        }

        return minDepth;
    }

    public static int minDepthByDFS(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
        //这种情况，没有考虑没有左或右子树的情况。
//        return Math.min(minDepthByDFS(root.left), minDepthByDFS(root.right)) + 1;
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepthByDFS(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepthByDFS(root.right), min_depth);
        }

        return min_depth + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode r9 = new TreeNode(3);
        TreeNode r20 = new TreeNode(4);
        TreeNode r15 = new TreeNode(5);
        TreeNode r7 = new TreeNode(6);

        root.right = r9;
        r9.right = r20;
        r20.right = r15;
        r15.right = r7;

        System.out.println("min depth= " + minDepth(root));
    }
}
