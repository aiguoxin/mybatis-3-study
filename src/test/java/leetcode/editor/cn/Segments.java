package leetcode.editor.cn;

/**
 * 6/16/22 16:33
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/number-of-segments-in-a-string/
 */
public class Segments {
    public static int countSegments(String s) {
        if(s == ""){
            return 0;
        }
        /** \s是指空白,包括空格、换行、tab缩进等所有的空白. s.split(" ")这么弄不行**/
        String[] strings = s.split("\\s+");
        return strings.length;
    }

    public static void main(String[] args) {
        String s =  "   ";
        System.out.println(countSegments(s));
    }
}
