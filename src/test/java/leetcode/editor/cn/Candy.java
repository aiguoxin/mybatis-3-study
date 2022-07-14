package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 7/13/22 22:22
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/distribute-candies/
 */
public class Candy {
    public static int distributeCandies(int[] candyType) {
        /***优化：放入set中，比较set和length/2大小****/
        int count = 1;
        int length = candyType.length;
        Arrays.sort(candyType);
        int pre = candyType[0];

        for (int i = 1; i < candyType.length; i++) {
            if (candyType[i] != pre) {
                pre = candyType[i];
                if (count == length / 2) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] candyType = {1, 11};
        System.out.println(distributeCandies(candyType));
    }
}
