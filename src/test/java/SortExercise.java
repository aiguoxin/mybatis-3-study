/** 2020/7/1 下午7:22 aiguoxin 说明: 各种排序算法 */
public class SortExercise {
    public static void main(String[] args) {
        int[] sortArray = new int[] {6, 3, 1, 2, 5, 0};
//        bubble(sortArray);
//        insert(sortArray);
        select(sortArray);
        for (int i = 0; i < sortArray.length; i++) {
            System.out.println(sortArray[i]);
        }
    }

    /**
     * 冒泡排序 稳定、时间复杂度O(n^2)
     *
     * @param sortArray
     */
    public static void bubble(int[] sortArray) {
        int size = sortArray.length;
        //        边界条件
        if (size < 2) return;
        for (int i = 0; i < size; i++) {
            //          标记后续数据是否有序，如果没有数据交换表示有序，就退出
            boolean noSwap = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (sortArray[j] > sortArray[j + 1]) {
                    int tmp = sortArray[j + 1];
                    sortArray[j + 1] = sortArray[j];
                    sortArray[j] = tmp;
                    noSwap = true;
                }
            }
            if (!noSwap) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * 稳定排序，时间复杂度O(n^2)，交换次数比冒泡少，所以一般使用插入，执行快
     * @param sortArray
     */
    public static void insert(int[] sortArray) {
        int size = sortArray.length;
        if (size < 2) return;

        for (int i = 1; i < size; i++) {
            // 记录要插入的元素值和位置
            int value = sortArray[i];
            //记录插入位置，放在循环括号外
            int j = i - 1;
            for (; j >= 0; j--) {
                if(sortArray[j] > value){
                    sortArray[j+1] = sortArray[j];
                }else {
                    break;
                }
            }
            sortArray[j+1] = value;
        }
    }

    /**
     * 选择排序
     * 时间复杂度O(n^2)  不稳定排序
     * 稳定：相同原始，排序前后位置保持不变
     * @param sortArray
     */
    public static void select(int[] sortArray){
        int size = sortArray.length;
        if(size < 2) return;

        for(int i = 0; i < size; i++){
            //找到未排序区域最小值及下标
            int minVal = sortArray[0];
            int min = i;
            for(int j = i+1; j < size; j++){
                //找到最小的值
                if(sortArray[j] < minVal){
                    minVal = sortArray[j];
                    min = j;
                }
            }
            //交换
            int temp = sortArray[min];
            sortArray[min] = sortArray[i];
            sortArray[i] = temp;
        }
    }

}
