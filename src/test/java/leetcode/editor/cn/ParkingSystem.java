package leetcode.editor.cn;

/**
 * 11/29/22 11:04
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/design-parking-system/
 * 优化：
 * 1、可以用个数组保存，addCar就简单点（Map方式）
 * 2、二进制分段法：https://leetcode.cn/problems/design-parking-system/solution/yi-ti-san-jie-jian-dan-bian-liang-ha-xi-0gs72/
 */

public class ParkingSystem {
    private int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        checkSize(big);
        checkSize(medium);
        checkSize(small);

        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    private void checkSize(int size) {
        if (size < 0 || size > 1000) {
            throw new IllegalArgumentException();
        }
    }

    public boolean addCar(int carType) {
        boolean flag;
        switch (carType) {
            case 1:
                big--;
                flag = big >= 0 ? true : false;
                break;
            case 2:
                medium--;
                flag = medium >= 0 ? true : false;
                break;
            case 3:
                small--;
                flag = small >= 0 ? true : false;
                break;
            default:
                throw new IllegalStateException();
        }
        return flag;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}
