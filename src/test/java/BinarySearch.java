/**
 *    Copyright 2009-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 2020/7/6 下午5:19
 * aiguoxin
 * 说明: 二分查找，针对有序数组
 */
public class BinarySearch {
    static int pos = 0;
    public static void main(String[] args) {
        int[] searchArray = {0,1,2,2,3,4,5};
//        stackMethod(searchArray,4);
        /**
         * 查找第一个元素位置，如果有重复元素
         */
//        pos = findFirst(searchArray,0, searchArray.length -1,4);
        /**
         * 查找最后一个元素位置，如果有重复元素
         */
//        pos = findLast(searchArray,0, searchArray.length -1,2);
        /**
         * 查找第一个小于等于的元素位置
         */
        pos = findFirstLe(searchArray,0, searchArray.length -1,3);
        System.out.println("the first pos is="+pos);
    }

    /**
     * 查找第一个小于等于的元素位置
     * @param searchArray
     * @param low
     * @param high
     * @param findVal
     * @return
     */
    private static int findFirstLe(int[] searchArray, int low, int high, int findVal) {
        if(low >= high)return low;
        int mid = low + ((high-low) >>> 1);
        if(findVal > searchArray[mid]){
            if(mid == 0 || searchArray[mid+1] >= findVal){
                return mid;
            }else {
                low = mid + 1;
            }
        }else{
            high = mid -1;
        }
        return findFirstLe(searchArray, low, high, findVal);
    }

    /**
     * 递归实现，找到中间节点
     * @param sortArray
     */
    public static void stackMethod(int[] sortArray, int findVal){
        int location = useStack(sortArray, 0, sortArray.length-1, findVal);
        System.out.println("location="+location);
    }

    private static int useStack(int[] sortArray, int low, int high, int findVal) {
        if(low >= high){
            return low;
        }
        //可以位操作，避免
        int middle = low + (high - low)/2;
        if(findVal == sortArray[middle]){
            return middle;
        }
        if(findVal > sortArray[middle]){
            low = middle + 1;
        }else{
            high = middle - 1;
        }
        return useStack(sortArray,low,high,findVal);
    }

   // 非递归实现及查找大于某个数的第一个数的位置
   private static int findFirst(int[] sortArray,int low, int high, int findVal){
        if(low >= high){
            return low;
        }
        int middle = low + ((high - low) >> 1);
       if(findVal > sortArray[middle]){
           low = middle + 1;
       }else if(findVal < sortArray[middle]){
           high = middle - 1;
       }else{
           if (sortArray[middle - 1] != findVal) {
               return middle;
           }else{
               high = middle - 1;
           }
       }
       return findFirst(sortArray,low,high,findVal);
   }

    // 非递归实现及查找大于某个数的最后一个数的位置
    private static int findLast(int[] sortArray,int low, int high, int findVal){
        if(low >= high){
            return low;
        }
        int middle = low + ((high - low) >> 1);
        if(findVal > sortArray[middle]){
            low = middle + 1;
        }else if(findVal < sortArray[middle]){
            high = middle - 1;
        }else{
            if (sortArray[middle + 1] != findVal) {
                return middle;
            }else{
                low = middle + 1;
            }
        }
        return findLast(sortArray,low,high,findVal);
    }

   public static void sysBinary(Integer[] sortArray,Integer findVal){
        List<Integer> list = new LinkedList<>();
        Collections.binarySearch(list, findVal);

   }
}
