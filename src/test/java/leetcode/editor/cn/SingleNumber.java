package leetcode.editor.cn;//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 
// 👍 2344 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution033114{
    /**
     * 借助了异或和额外标记数组，性能太差。
     * 异或：相同异或为0，0与自身异或则为1。所以，遍历数组，全部元素异或即可得结果！！！
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int[] flag = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == -1) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (flag[j] == -1) {
                    continue;
                }
                if ((nums[i] ^ nums[j]) == 0) {
                    flag[i] = -1;
                    flag[j] = -1;
                }
            }
        }

        for (int i = 0; i < flag.length; i++) {
            if (flag[i] != -1) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 输入: [2,2,1]
//输出: 1
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
