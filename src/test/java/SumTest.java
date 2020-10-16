package com.agx;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020/10/16 下午6:02
 * aiguoxin
 * 说明:
 * 问题内容是：给定一个数组，给定一个数字。返回数组中可以相加得到指定数字的两个索引。
 *
 * 比如：给定nums = [2, 7, 11, 15], target = 9
 * 那么要返回 [0, 1]，因为2 + 7 = 9
 */
public class SumTest {
    static Map<Integer,Integer> dataMap = new HashMap<>();

    public static void main(String[] args) {
        Integer[] nums = {2,7,11,15};
        printTarget(nums,18);
    }

    private static void printTarget(Integer[] nums, int target) {
        for(Integer i=0; i<nums.length; i++){
            Integer currentVal = target-nums[i];
            if(dataMap.containsKey(currentVal)){
                System.out.println(dataMap.get(currentVal)+","+i);
                break;
            }else{
                dataMap.put(nums[i],i);
            }
        }
    }
}
