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
//        pos = findFirst(searchArray,0, searchArray.length -1,4);
        pos = findLast(searchArray,0, searchArray.length -1,2);
        System.out.println("the first pos is="+pos);
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
