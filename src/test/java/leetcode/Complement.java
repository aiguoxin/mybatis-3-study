package leetcode;

/**
 * 6/22/22 22:02
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/number-complement/
 */
public class Complement {
    //    public static int findComplement(int num) {
//        return (((Integer.highestOneBit(num) << 1) - 1)) ^ num;
    public static int findComplement(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        //1向右移动hightbit+1次
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }


    public static void main(String[] args) {
//        System.out.println(findComplement(5));
        System.out.println(1<<3);
    }

}
