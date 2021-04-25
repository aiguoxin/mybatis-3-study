package java8;

import java.util.Optional;

/**
 * 2021/4/23 下午3:40
 * aiguoxin
 * 说明:
 */
public class NullTest {
    public static void main(String[] args) {
        String name = null;
        name = Optional.ofNullable(name).orElse("");
        System.out.println("name="+name);
    }
}
