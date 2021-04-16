package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/** 2021/4/16 下午6:10 aiguoxin 说明: 比较Map与FlatMap区别 */
public class FlatMapTest {

    public static void main(String[] args) {
        String s1 = "This is a";
        String s2 = "flatMap example";

        List<String> result =
                Stream.of(s1, s2)
                        .flatMap(s -> Stream.of(s.split(" ")))
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
        assertEquals(Arrays.asList("THIS", "IS", "A", "FLATMAP", "EXAMPLE"), result);
        System.out.println("list=" + result);
    }
}
