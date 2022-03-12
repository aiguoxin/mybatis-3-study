package leetcode.editor.cn;//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为5。
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为4。
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为6的“joyboy”。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
// Related Topics 字符串 
// 👍 434 👎 0


import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution031223{
    public static int lengthOfLastWord(String s) {
        int max = 0;
        //借助了额外空间，也可以使用charAt方法定位
        char[] sChar = s.toCharArray();
        boolean first = true;
        //当时i>0，没考虑=0情况
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!Objects.equals(' ', sChar[i])) {
                max++;
                first = false;
            } else {
                if(!first){
                    break;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
