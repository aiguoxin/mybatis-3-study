import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 2020/7/6 下午5:19
 * aiguoxin
 * 说明: 二分查找，针对有序数组
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] searchArray = {0,1,2,3,4,5};
        stackMethod(searchArray,4);
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

   //todo 非递归实现及查找大于某个数的第一个数的位置

   public static void sysBinary(Integer[] sortArray,Integer findVal){
        List<Integer> list = new LinkedList<>();
        Collections.binarySearch(list, findVal);

   }
}
