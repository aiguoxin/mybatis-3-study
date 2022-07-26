package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 7/26/22 08:19
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/uncommon-words-from-two-sentences/
 */
public class Sentence {
    public static String[] uncommonFromSentences(String s1, String s2) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        Arrays.stream(s1.split(" ")).forEach(e -> {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        });
        Arrays.stream(s2.split(" ")).forEach(e -> {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        });
        countMap.entrySet().stream().forEach(e -> {
            if (e.getValue() == 1) {
                result.add(e.getKey());
            }
        });

        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        String s1 = "ad dfd df";
        String s2 = "ad df";
        System.out.println(uncommonFromSentences(s1, s2));
    }
}
