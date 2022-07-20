package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 7/20/22 08:21
 * aiguoxin 
 * 说明:
 */
public class DivideNo {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            int div = i;
            boolean flag = true;
            while (div != 0) {
                int no = div % 10;
                div = div / 10;
                if (no == 0) {
                    flag = false;
                    break;
                } else {
                    if (i % no != 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(47, 85));
    }
}
