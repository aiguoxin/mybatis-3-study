package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import leetcode.bfs.TreeNode;

/**
 * 8/12/22 20:53
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/
 */
public class SumBst {
    public static boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> nodeMap = new HashMap<>();
        addNode(root, nodeMap);
        for (Map.Entry<Integer, Integer> entry : nodeMap.entrySet()) {
            if (nodeMap.get(k - entry.getKey()) != null) {
                if(entry.getKey() == (k - entry.getKey())){
                    if(nodeMap.get(entry.getKey()) > 1){
                        return true;
                    }
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    private static void addNode(TreeNode root, Map<Integer, Integer> nodeMap) {
        if (root != null) {
            nodeMap.put(root.val, 1);
            addNode(root.left, nodeMap);
            addNode(root.right, nodeMap);
        }
    }

    public static void main(String[] args) {

    }
}
