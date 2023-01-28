package leetcode.string;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * 1/28/23 17:19
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/goat-latin/
 *
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 */
public class GoatLatin {
    public String toGoatLatin(String sentence) {
        Set<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('e');
        characters.add('i');
        characters.add('o');
        characters.add('u');

        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Character first = word.charAt(0);
            if (characters.contains(Character.toLowerCase(first))) {
                word += "ma";
            } else {
                word = word.substring(1) + first + "ma";
            }
            for (int j = 0; j < i + 1; j++) {
                word += 'a';
            }
            res.append(word).append(" ");
        }
        return res.toString().trim();
    }

    @Test
    public void test() {
        String sentence = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(sentence));
    }
}
