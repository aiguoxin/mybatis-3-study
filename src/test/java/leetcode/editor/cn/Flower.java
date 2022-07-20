package leetcode.editor.cn;

/**
 * 7/20/22 22:03
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/can-place-flowers/
 */
public class Flower {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i > 0 && i < flowerbed.length - 1 && flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
            if (i == 0) {
                if (flowerbed[i] == 0) {
                    if (flowerbed.length == 1) {
                        return true;
                    }
                    if (flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                }
            }
            if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }

            if (count == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
