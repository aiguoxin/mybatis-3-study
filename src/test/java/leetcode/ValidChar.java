/**
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
