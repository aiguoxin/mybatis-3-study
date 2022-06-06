package leetcode.editor.cn;//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 105 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 333 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution06015{
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rMap = new HashMap<>();
        Map<Character, Integer> mMap = new HashMap<>();
        for (char ch : ransomNote.toCharArray()) {
            Integer o = rMap.get(ch);
            if (Objects.isNull(o)) {
                rMap.put(ch, 1);
            } else {
                rMap.put(ch, o + 1);
            }
        }

        for (char ch : magazine.toCharArray()) {
            Integer o = mMap.get(ch);
            if (Objects.isNull(o)) {
                mMap.put(ch, 1);
            } else {
                mMap.put(ch, o + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : rMap.entrySet()) {
            if (Objects.nonNull(mMap.get(entry.getKey())) && mMap.get(entry.getKey()) >= entry.getValue()) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
