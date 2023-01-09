package leetcode.array;

import org.junit.Test;

/**
 * 1/9/23 19:23
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/find-smallest-letter-greater-than-target/
 */
public class SmallLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int idx = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] - target > 0) {
                idx = i;
                break;
            }
        }
        return letters[idx];
    }


    @Test
    public void test() {
        char[] letters = {'x', 'x', 'y', 'y'};
        System.out.println(nextGreatestLetter(letters, 'z'));
    }
}
