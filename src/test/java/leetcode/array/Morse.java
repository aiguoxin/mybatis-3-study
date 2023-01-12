package leetcode.array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/unique-morse-code-words/
 */
public class Morse {
    String[] morseArray = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        if(words.length ==1){
            return 1;
        }
        Set<String> morseSet = new HashSet<>();

        for(String word : words){
            StringBuilder sb = new StringBuilder();
           char[] chars = word.toCharArray();
           for(char ch : chars){
               int idx = ch-'a';
               sb.append(morseArray[idx]);
           }
           morseSet.add(sb.toString());
        }
        return morseSet.size();
    }

    @Test
    public void test(){
        String[] words = {"a"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
