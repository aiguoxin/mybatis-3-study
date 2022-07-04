package leetcode.editor.cn;

/**
 * 7/4/22 22:42
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWord {

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            res.append(new StringBuilder(word).reverse()).append(" ");
        }
        return res.deleteCharAt(res.length()-1).toString();
    }

    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        System.out.println(reverseWord.reverseWords("God Ding"));
    }
}
