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
