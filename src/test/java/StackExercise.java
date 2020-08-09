/**
 *    Copyright 2009-2020 the original author or authors.
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
import org.mockito.internal.util.collections.Sets;

import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * 2020/6/29 下午4:51
 * aiguoxin
 * 说明: 栈操作练习
 */
public class StackExercise {
    public static void main(String[] args) {
        boolean check = checkMatch("([{}()[]])");
        System.out.println("检测括号是否匹配check="+check);
    }

    /**
     * 检测括号是否匹对如："[{}()[]]"
     * @param checkStr
     * @return
     */
    public static boolean checkMatch(String checkStr){
        Set<Character> leftSet = Sets.newSet('[','{','(');
        Set<Character> rightSet = Sets.newSet(']','}',')');
        char[] charArray = checkStr.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : charArray){
            if(leftSet.contains(c)){
                stack.push(c);
            }
            if(rightSet.contains(c)){
                if(stack.isEmpty()){
                    return false;
                }
                char left = stack.pop();
                if (Objects.equals(']',c) && !Objects.equals('[',left)) {
                    return false;
                }
                if (Objects.equals('}',c) && !Objects.equals('{',left)) {
                    return false;
                }
                if (Objects.equals(')',c) && !Objects.equals('(',left)) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
