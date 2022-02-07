package java8;

import java.util.BitSet;

/**
 * 2022/2/7 下午6:30
 * aiguoxin
 * 说明:
 */
public class BitSetTest {
    public static void main(String[] args) {
        BitSet bs1 = new BitSet();
        bs1.set(0);
        bs1.set(2);
        bs1.set(4);
        System.out.println("bs1 : " + bs1);

        BitSet bs2 = new BitSet();
        bs2.set(1);
        bs2.set(2);
        bs2.set(3);
        System.out.println("bs2 : " + bs2);

        bs2.xor(bs1);
        System.out.println("xor: " + bs2);
    }
}
