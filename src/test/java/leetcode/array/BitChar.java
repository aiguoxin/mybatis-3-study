package leetcode.array;

import org.junit.Test;

/**
 * 12/6/22 11:04
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/1-bit-and-2-bit-characters/
 * 初始考虑：没想出来，总是想到比较数据是否一样。应该从下标考虑！！
 */
public class BitChar {

    public boolean isOneBitCharacterError(int[] bits) {
        int length = bits.length;
        if (length == 1) {
            return true;
        } else if (length == 2) {
            if (bits[0] == 0) {
                return true;
            } else {
                return false;
            }
            //大于2，确认0到n-2可以解码
        } else {
            int last = 0;
            for (int i = 0; i < length - 2; i++) {
                last = bits[i];
                if (bits[i] == 0) {
                    continue;
                } else {
                    i++;
                }
            }
            if (last == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        int i=0;
        while(i < length-1){
            if(bits[i] == 0){
                i++;
            }else if(bits[i] == 1){
                i += 2;
            }
        }
        return i == length-1;
    }

        @Test
    public void test() {
//        输入: bits = [1, 0, 0]
//输出: true
        int[] bits = {1, 0, 0};
        System.out.println(isOneBitCharacter(bits));
    }
}
