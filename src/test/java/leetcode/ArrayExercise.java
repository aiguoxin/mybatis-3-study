package leetcode;

import java.util.*;

/** 2020/11/19 下午10:08 aiguoxin 说明: */
public class ArrayExercise {
    public static void main(String[] args) {
        // 前提：有序数组
        //        int[] a = {
        //            1, 1, 1, 1, 1, 1, 2, 3, 3,
        //        };
        //        int length = rmVal(a, 1);
        //        System.out.println("length=" + length);
        //        for (int i = 0; i < a.length; i++) {
        //            System.out.println(a[i]);
        //        }

        //        int[] nums = {1, 2, 3, 4, 5};
        //        int[] result = twoSum(nums, 9);
        //        System.out.println(String.format("%s,%s", result[0], result[1]));

        //        int initVal = 1534236469;
        //        System.out.println(reverse(initVal));

        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        findSumIsZero(nums);
    }

    /**
     * Remove Duplicates from Sorted Array Given a sorted array, remove * the duplicates in place
     * such that each element appear only once and return the new length. Do not * allocate extra
     * space for another array, you must do this in place with constant memory. For * example, given
     * input array A = [1,1,2], your function should return length = 2, and A is now * [1,2].
     */
    public static int removeDuplicates(int[] A) {
        if (A.length < 2) return A.length;

        int j = 0;
        int i = 1;
        while (i < A.length) {
            if (A[i] != A[j]) {
                j++;
                A[j] = A[i];
            }
            i++;
        }

        return j + 1;
    }

    /**
     * 移除重复元素，最多保留3个，如：[1,1,1,1,2,2,3]->[1,1,1,2,2,3] 通用解法：比较第一个元素和前一个元素，是否和当前元素相等
     *
     * @return
     */
    public static int removeDuplicatesRetainMost3(int[] A) {
        if (A.length < 4) {
            return A.length;
        }

        int i = 2; // previous
        int j = 3; // current
        while (j < A.length) {
            if (A[i] == A[j] || A[i - 2] == A[j]) {
                j++;
            } else {
                i++;
                A[i] = A[j];
                j++;
            }
        }

        return i + 1;
    }

    /**
     * 移除指定元素，返回新长度
     *
     * @param A
     * @param value
     * @return
     */
    public static int rmVal(int[] A, int value) {
        int i = 0;
        int j = 0;
        while (j < A.length) {
            if (A[j] != value) {
                A[i] = A[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static int[] twoSum(int[] nums, int target) {
        assert nums.length > 1;
        Map<Integer, Integer> valMap = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int findVal = target - nums[i];
            if (valMap.containsKey(findVal)) {
                result[0] = valMap.get(findVal);
                result[1] = i;
                break;
            } else {
                valMap.put(nums[i], i);
            }
        }

        return result;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     *
     * @param x 需要改进：应该使用%10、/10方式模拟出栈入栈
     * @return 思路不对！！！！
     */
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long result = 0;
        char[] resultChar = String.valueOf(x).toCharArray();
        int length = resultChar.length;
        int i = 0;
        if (x < 0) {
            i = 1;
        }

        for (int j = length - 1; j > i; j--) {
            char temp = resultChar[i];
            resultChar[i] = resultChar[j];
            resultChar[j] = temp;
            i++;
        }
        for (int k = resultChar.length - 1; k >= 0; k--) {
            if (x > 0 || (x < 0 && k > 0)) {
                result +=
                        Integer.valueOf(String.valueOf(resultChar[k]))
                                * Math.pow(10, resultChar.length - k - 1);
            }
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        } else {
            if (x < 0) {
                return -Integer.valueOf(String.valueOf(result));
            }
            return Integer.valueOf(String.valueOf(result));
        }
    }

    /**
     * 找出所有和为0且不重复的三元组如： nums=[-1,0,1,-1,2,-1,-4] 输出: [[-1,-1,2],[-1,0,1]]
     * https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     * 缺点：三重循环太耗时，需要双指针操作
     * @param nums
     */
    public static List<List<Integer>> findSumIsZero(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //        Map<String,Integer> filterMap = new HashMap<>();

        for (int i = 0; i < length - 2; i++) {
            if (i == 0 && nums[i] > 0) {
                break;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < length - 1; j++) {
                    if (j == i+1 || nums[j] != nums[j - 1]) { // 去掉重复
                        for (int k = j + 1; k < length; k++) {
                            if (k == j+1 || nums[k] != nums[k - 1]) {
                                int total = nums[i] + nums[j] + nums[k];
                                if (total == 0) {
                                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                                    //                                    // 去掉重复的，使用map超时
                                    // list.sort(Comparator.comparingInt(Integer::intValue));
                                    //                        String key =
                                    // list.stream().map(e->String.valueOf(e)).collect(Collectors.joining(","));
                                    //                        if(filterMap.get(key) == null){
                                    result.add(list);
                                    //                            filterMap.put(key,1);
                                    //                        }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
