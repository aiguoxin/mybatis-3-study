package leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * 2021/2/2 上午8:22
 * aiguoxin
 * 说明:
 */
public class ValidChar {
    public static void main(String[] args) {
        String test = "[]";
        System.out.println(isValid(test));
    }

    public static boolean isValid(String s) {
        if(s == null || s.isEmpty()){
            return false;
        }
        char[] validCharArray = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        Set<Character> left = new HashSet<>();
        left.add('(');
        left.add('[');
        left.add('{');
        Set<Character> right = new HashSet<>();
        right.add(')');
        right.add(']');
        right.add('}');

        for (Character c : validCharArray){
            if(left.contains(c)){
                characterStack.push(c);
            }

            if(right.contains(c)){
//                必须判空，否则抛出异常
                if(characterStack.isEmpty()){
                    return false;
                }
                char leftChar = characterStack.pop();
                if (Objects.equals('[',leftChar) && !Objects.equals(']',c)) {
                    return false;
                }
                if (Objects.equals('(',leftChar) && !Objects.equals(')',c)) {
                    return false;
                }
                if (Objects.equals('{',leftChar) && !Objects.equals('}',c)) {
                    return false;
                }
            }
        }
        if(!characterStack.isEmpty()){
            return false;
        }
        return true;
    }
}
