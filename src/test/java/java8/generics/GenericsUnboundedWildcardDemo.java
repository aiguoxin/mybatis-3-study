package java8.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2022/1/29 下午3:11
 * aiguoxin
 * 说明:
 * 无界通配符有两种应用场景：
 * <p>
 * 可以使用 Object 类中提供的功能来实现的方法。
 * 使用不依赖于类型参数的泛型类中的方法。
 * <p>
 * 语法形式：<?>
 */
public class GenericsUnboundedWildcardDemo {

    /**两种写法都可以，只是无界通配符更简洁**/
    public static <E> void printList(List<E> list) {
        for (E e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void printListOther(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    /**两种写法都可以，只是无界通配符更简洁**/


    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);

        /**泛型不能向上转型。但是，我们可以通过使用通配符来向上转型。**/
//        List<Integer> intList = new ArrayList<>();
//        List<Number> numList = intList;  // Error

        List<? extends Integer> intList2 = new ArrayList<>();
        List<? extends Number> numList2 = intList2;  // OK
        /**泛型不能向上转型。但是，我们可以通过使用通配符来向上转型。**/


    }
}
