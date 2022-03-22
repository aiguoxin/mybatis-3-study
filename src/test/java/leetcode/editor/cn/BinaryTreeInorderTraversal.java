package leetcode.editor.cn;//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1330 👎 0


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
class Solution032117 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        middle(root, list);
        return list;
    }

    private static void middle(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            middle(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            middle(root.right, list);
        }
    }

    public static void main(String[] args) {
        //root = [1,null,2,3]
        //输出：[1,3,2]
        TreeNode n1 = null;
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//
//        n1.right = n2;
//        n2.left = n3;
        List<Integer> list = inorderTraversal(n1);
        list.stream().forEach(num -> System.out.println(num));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
