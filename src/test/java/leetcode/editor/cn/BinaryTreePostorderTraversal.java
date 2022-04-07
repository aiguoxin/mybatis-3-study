package leetcode.editor.cn;//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 802 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;
import leetcode.bfs.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution040618{
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList();
        if (root == null) {
            return list;
        }
        preOrder(list, root);
        return list;
    }

    private static void preOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(list, root.left);
        preOrder(list, root.right);
        list.add(root.val);
    }

    public static void main(String[] args) {
        //输入：root = [1,null,2,3]
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.right = n1;
        n1.left = n2;
        List<Integer> result = postorderTraversal(root);
        result.forEach(e-> System.out.println(e));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
