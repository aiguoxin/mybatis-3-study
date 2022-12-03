package leetcode.tree;

import leetcode.bfs.TreeNode;
import org.junit.Test;

/**
 * 12/3/22 18:09
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/search-in-a-binary-search-tree/
 */
public class SearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null){
            if (root.val == val) {
                return root;
            }
            if (root.left != null) {
               TreeNode result =  searchBST(root.left, val);
               if(result != null){
                   return result;
               }
            }
            if (root.right != null) {
                TreeNode result =  searchBST(root.right, val);
                if(result != null){
                    return result;
                }
            }
        }
        return null;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);

        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        root.left = n2;
        root.right = n7;

        n2.left = n1;
        n2.right = n3;

        TreeNode treeNode = searchBST(root,3);
        System.out.println(treeNode);
    }

}
