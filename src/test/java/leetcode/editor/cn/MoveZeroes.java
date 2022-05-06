package leetcode.editor.cn;//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
//
// 示例 1:
//
//
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
//
// 示例 2:
//
//
//输入: nums = [0]
//输出: [0]
//
//
//
// 提示:
//
//
//
// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
//
//
//
//
// 进阶：你能尽量减少完成的操作次数吗？
// Related Topics 数组 双指针
// 👍 1574 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution050614{
    public static void moveZeroes(int[] nums) {
        //双指针没想到！另外：两遍循环，把非0的都迁移，后面补零
        int left = 0, right = 0;
        int length = nums.length;
        while (right < length) {
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }

        Arrays.stream(nums).forEach(e-> System.out.println(e));
    }

    public static void main(String[] args) {
        //输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
