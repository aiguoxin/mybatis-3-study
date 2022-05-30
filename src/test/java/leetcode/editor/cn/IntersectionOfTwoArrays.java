package leetcode.editor.cn;//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 550 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution053012{
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        Arrays.stream(nums1).forEach(num -> nums1Set.add(num));
        Arrays.stream(nums2).forEach(num -> {
            if (nums1Set.contains(num)) {
                result.add(num);
            }
        });
        int[] res = new int[result.size()];
        List<Integer> list = result.stream().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        /**  不转换成list的一种方法
         int idx = 0;
         for (int value : result) {
         res[idx++] = value;
         }
         **/


        /**另一种解法：排序+双指针**/

        return res;
    }

    public static void main(String[] args) {
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = intersection(nums1, nums2);
        Arrays.stream(res).forEach(num -> System.out.println(num));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
