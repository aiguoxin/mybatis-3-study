package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 7/14/22 08:10
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/robot-return-to-origin/
 */
public class Robot {
    public static boolean judgeCircle(String moves) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character ch : moves.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        return Objects.equals(charMap.get('U'), charMap.get('D'))
                && Objects.equals(charMap.get('L'), charMap.get('R'));
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("LR"));
    }
}
