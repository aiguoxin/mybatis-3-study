package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import leetcode.bfs.TreeNode;

/**
 * 7/3/22 20:22
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * 心得：树的遍历，借用了栈，可以使用Morris遍历把空间复杂度由O(n)->O(1)!!!!
 * https://ghh3809.github.io/2018/08/06/morris-traversal/
 */
public class Mode {
    Map<Integer, Integer> countMap = new TreeMap<>();

    public int[] findMode(TreeNode root) {
        look(root);
        /***
         * 可以在遍历过程中优化
         */
        int max = 1;
        for (Integer value : countMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }

        int[] resArray = new int[res.size()];
        int idx = 0;
        for (Integer val : res) {
            resArray[idx++] = val;
        }
        return resArray;
    }

    private void look(TreeNode root) {
        if (root != null) {
            countMap.put(root.val, countMap.getOrDefault(root.val, 0) + 1);
            look(root.left);
            look(root.right);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        root.right = n2;
        n2.left = n3;
        Mode mode = new Mode();
        int[] res = mode.findMode(root);
        System.out.println(Arrays.toString(res));
    }
}
