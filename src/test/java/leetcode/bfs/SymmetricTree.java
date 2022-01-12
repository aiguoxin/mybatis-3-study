package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2022/1/7 下午4:13
 * aiguoxin
 * 说明: 判断是否对称二叉树 https://leetcode-cn.com/problems/symmetric-tree/
 * root = [1,2,2,3,4,4,3] 是
 * root = [1,2,2,null,3,null,3] 否
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        //主要思路，转化成两个root
        return check(root, root);
    }

    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        //需要判断这个条件
        if (p.val != q.val) {
            return false;
        }
        //递归实现
        return check(p.left, q.right) && check(p.right, q.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t44 = new TreeNode(4);
        TreeNode t33 = new TreeNode(3);

        root.left = t2;
        root.right = t22;

        t2.left = t3;
        t2.right = t4;

        t22.left = t44;
        t22.right = t33;

//        System.out.println("tree is symmetric = " + isSymmetric(root));

        System.out.println("tree is symmetric = " + isSymmetricForBfs(root));
    }


    /**
     * 使用bfs，队列。主要思路：拆成2棵树，放入队列，每次取2个相邻的，一样才对称
     */
    public static boolean isSymmetricForBfs(TreeNode root) {
        //主要思路，转化成两个root
        if (root == null) {
            return true;
        }
        return bfs(root, root);
    }

    private static boolean bfs(TreeNode p, TreeNode q) {
        Queue<TreeNode> treeList = new LinkedList();
        treeList.add(p);
        treeList.add(q);
        while (!treeList.isEmpty()) {
            TreeNode left = treeList.poll();
            TreeNode right = treeList.poll();

            if (left == null && right == null) {
//                return false;   //不是false，可能都是空的情况
                continue;
            }
            if (left.val == right.val) {
                treeList.add(left.left);
                treeList.add(right.right);

                treeList.add(left.right);
                treeList.add(right.left);
            } else {
                return false;
            }
        }

        return true;
    }

}
