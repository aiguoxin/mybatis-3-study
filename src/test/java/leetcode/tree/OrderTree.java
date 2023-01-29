package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import leetcode.bfs.TreeNode;
import org.junit.Test;

/**
 * 1/29/23 17:19
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/increasing-order-search-tree/
 * 思路：按照值大小放入list中，再组合成单链表形式。借助了dummyNode节点
 */
public class OrderTree {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        setList(root,res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currentNode = dummyNode;

        for(Integer value : res){
            currentNode.right = new TreeNode(value);
            currentNode = currentNode.right;

        }
        return dummyNode.right;
    }

    private void setList(TreeNode root, List<Integer> res) {
        if(root == null){
            return;
        }
        setList(root.left,res);
        res.add(root.val);
        setList(root.right,res);
    }

    @Test
    public void test(){

    }
}
