package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 7/31/22 16:49
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/shortest-distance-to-a-character/
 */
public class ShortDis {
    public static int[] shortestToChar(String s, char c) {
        char[] sCh = s.toCharArray();
        int[] res = new int[sCh.length];
        List<Integer> idxSet = new ArrayList<>();

        for (int i = 0; i < sCh.length; i++) {
            if (Objects.equals(c, sCh[i])) {
                idxSet.add(i);
            }
        }

        for (int i = 0; i < sCh.length; i++) {
            if (idxSet.contains(i)) {
                res[i] = 0;
                continue;
            } else {
                int dis = Integer.MAX_VALUE;
                for (int j = 0; j < idxSet.size(); j++) {
                    int val = Math.abs(i - idxSet.get(j));
                    if (val < dis) {
                        dis = val;
                    }
                }
                res[i] = dis;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(Arrays.toString(shortestToChar(s, 'e')));
    }
}
