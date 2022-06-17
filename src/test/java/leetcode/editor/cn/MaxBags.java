package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 6/16/22 22:25
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/maximum-bags-with-full-capacity-of-rocks/
 */
public class MaxBags {

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count = 0;
//        int total = 0;
        int[] result = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            result[i] = capacity[i] - rocks[i];
//            total += result[i];
        }

        /*****这个不对，总和相等，并不一定能分配到每个背包中!!!!*******/
//        if (total <= additionalRocks) {
//            return capacity.length;
//        }

        Arrays.sort(result);
        for (int j = 0; j < capacity.length; j++) {
            additionalRocks = additionalRocks - result[j];
            if (additionalRocks >= 0) {
                count++;
            }else{
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {

//        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }
}
