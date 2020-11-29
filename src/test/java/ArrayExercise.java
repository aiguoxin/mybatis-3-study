/** 2020/11/19 下午10:08 aiguoxin 说明: */
public class ArrayExercise {
    public static void main(String[] args) {
        // 前提：有序数组
        int[] a = {
            1, 1, 1, 1, 1, 1, 2, 3, 3,
        };
        int length = removeDuplicatesRetainMost3(a);
        System.out.println("length=" + length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
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
     * 移除重复元素，最多保留3个，如：[1,1,1,1,2,2,3]->[1,1,1,2,2,3]
     * 通用解法：比较第一个元素和前一个元素，是否和当前元素相等
     * @return
     */
    public static int removeDuplicatesRetainMost3(int[] A) {
        if (A.length < 4) {
            return A.length;
        }

        int i = 2; //previous
        int j = 3; //current
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
}
