package leetcode.editor.cn;

import java.util.Set;
import java.util.TreeSet;
import leetcode.bfs.TreeNode;

/**
 * 8/13/22 14:26
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/
 */
public class SecondNode {
    static Set<Integer> tSet = new TreeSet<>();

    public static int findSecondMinimumValue(TreeNode root) {
        if (root != null) {
            tSet.add(root.val);
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }

        if (tSet.size() > 1) {
            int count = 0;
            for (Integer t : tSet) {
                count++;
                if (count == 2) {
                    return t;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
