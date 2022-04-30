package leetcode.editor.cn;//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 
// 👍 724 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
class Solution043022{
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        addPath(root,"",res);
        return res;
    }

    /**这个递归比较难考虑到！！！！弱项**/
    private static void addPath(TreeNode node, String path, List<String> res) {
        if(node != null){
            StringBuilder s = new StringBuilder(path);
            s.append(node.val);
            if(node.left == null && node.right == null){
                res.add(s.toString());
            }else{
                s.append("->");
                addPath(node.left,s.toString(),res);
                addPath(node.right,s.toString(),res);
            }

        }
    }

    public static void main(String[] args) {
        //输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);

        root.left = n2;
        root.right = n3;

        n2.right = n5;
        binaryTreePaths(root).stream().forEach(num-> System.out.println(num));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
