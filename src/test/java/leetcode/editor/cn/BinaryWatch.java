package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 6/11/22 18:11
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/binary-watch/
 */
public class BinaryWatch {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> resultList = new LinkedList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                /**注意Integer.bitCount使用!!!**/
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    resultList.add(h + ":" + (m > 9 ? "" : "0") + m);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        readBinaryWatch(1)
                .stream()
                .forEach(data -> System.out.println(data));
    }
}
