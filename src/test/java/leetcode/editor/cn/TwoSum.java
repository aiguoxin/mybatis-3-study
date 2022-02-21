package leetcode.editor.cn;//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than O(n2) time comp
//lexity? Related Topics 数组 哈希表 
// 👍 13477 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> dataMap = new HashMap<>();
        int[] result =new int[2];
        for(Integer i=0; i<nums.length; i++){
            Integer currentVal = target-nums[i];
            if(dataMap.containsKey(currentVal)){
                System.out.println(dataMap.get(currentVal)+","+i);
                result[0] = dataMap.get(currentVal);
                result[1] = i;
                return result;
            }else{
                dataMap.put(nums[i],i);
            }
        }
        throw new RuntimeException("not find");
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        twoSum(nums,6);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
