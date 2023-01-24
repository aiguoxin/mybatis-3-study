package leetcode.array;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * 1/19/23 17:09
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/most-common-word/
 * !?',;.
 */
public class MostWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("!", " ").replaceAll("\\?", " ").replaceAll("'", " ")
                .replaceAll(",", " ").replaceAll(";", " ").replaceAll("\\.", " ");

        TreeMap<String, Integer> wordMap = new TreeMap<>();
        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
        for (String word : paragraph.split(" ")) {
            if(!Objects.equals("",word.trim())) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }
        AtomicInteger count = new AtomicInteger();
        AtomicReference<String> word = new AtomicReference<>();

        wordMap.entrySet().stream().filter(entry -> !bannedSet.contains(entry.getKey())).forEach(entry -> {
            if (entry.getValue() > count.get()) {
                count.set(entry.getValue());
                word.set(entry.getKey());
            }
        });
        return word.get() != null ? word.get() : "";
    }


    @Test
    public void test() {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}
