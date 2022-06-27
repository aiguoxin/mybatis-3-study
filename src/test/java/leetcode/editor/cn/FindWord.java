package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 6/27/22 22:07
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/keyboard-row/
 */
public class FindWord {
    //优化：可以        String rowIdx = "12210111011122000010020202";标记所有字母。另外
    public static String[] findWords(String[] words) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> charMap = new HashMap<>();
        String one = "qwertyuiop";
        String two = "asdfghjkl";
        String three = "zxcvbnm";
        for (Character ch : one.toCharArray()) {
            charMap.put(ch + "", 1);
        }
        for (Character ch : two.toCharArray()) {
            charMap.put(ch + "", 2);
        }
        for (Character ch : three.toCharArray()) {
            charMap.put(ch + "", 3);
        }

        for (String word : words) {
//            Character.toLowerCase(ch)
            Integer value = charMap.get(String.valueOf(word.charAt(0)).toLowerCase());
            boolean flag = true;
            for (Character ch : word.toCharArray()) {
                if (charMap.get(String.valueOf(ch).toLowerCase()) != value) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }

        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String[] words = {"adsd", "sfd"};
        String[] res = findWords(words);
        Arrays.stream(res).forEach(e -> System.out.println(e));
    }
}
