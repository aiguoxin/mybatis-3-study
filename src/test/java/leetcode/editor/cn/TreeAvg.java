package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import leetcode.bfs.TreeNode;

/**
 * 7/31/22 15:43
 * aiguoxin 
 * 说明:
 */
public class TreeAvg {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new LinkedList<>();
        Deque<TreeNode> treeQ = new ArrayDeque<>();
        treeQ.add(root);
        while (!treeQ.isEmpty()) {
            int size = treeQ.size();
            int num = size;
            //注意越界
            long sum = 0;
            while (size != 0) {
                TreeNode node = treeQ.pop();
                size--;
                sum += node.val;
                if (node.left != null) {
                    treeQ.add(node.left);
                }
                if (node.right != null) {
                    treeQ.add(node.right);
                }
            }
            Double res = (double) sum / num;
            resList.add(res);
        }

        return resList;
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(2147483647);
        TreeNode n9 = new TreeNode(2147483647);
        TreeNode n20 = new TreeNode(2147483647);

        n3.left = n9;
        n3.right = n20;
        System.out.println(averageOfLevels(n3));
    }

}
