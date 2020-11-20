/**
 * 2020/11/19 下午10:08 aiguoxin
 * 说明: Remove Duplicates from Sorted Array Given a sorted array, remove
 * the duplicates in place such that each element appear only once and return the new length. Do not
 * allocate extra space for another array, you must do this in place with constant memory. For
 * example, given input array A = [1,1,2], your function should return length = 2, and A is now
 * [1,2].
 */
public class ArrayExercise {
    public static void main(String[] args) {
        //前提：有序数组
        int[] a = {1, 1, 2, 3, 3};
        int length = removeDuplicates(a);
        System.out.println("length=" + length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

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
}
