package leetcode.editor.cn;

import leetcode.bfs.TreeNode;

/**
 * 7/30/22 10:22
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/merge-two-binary-trees/
 */
public class MergeTree {

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //先序遍历，放到数组，合并数组，再放入树中，不可取！！！
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }

        TreeNode mergedNode = new TreeNode(root1.val+ root2.val);
        mergedNode.left = mergeTrees(root1.left,root2.left);
        mergedNode.right = mergeTrees(root1.right,root2.right);
        return mergedNode;
    }

    public static void main(String[] args) {

    }

}
