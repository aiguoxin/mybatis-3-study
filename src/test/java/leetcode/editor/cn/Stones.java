package leetcode.editor.cn;

import java.util.Objects;

/**
 * 7/19/22 22:11
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/jewels-and-stones/
 */
public class Stones {

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char s : jewels.toCharArray()) {
            for (char t : stones.toCharArray()) {
                if (Objects.equals(s, t)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
