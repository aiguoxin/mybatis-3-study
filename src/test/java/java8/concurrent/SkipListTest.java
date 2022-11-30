package java8.concurrent;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.junit.Test;

/**
 * 11/29/22 17:59
 * aiguoxin 
 * 说明: 跳表test
 */
public class SkipListTest {

    @Test
    public void testSkipListMap() {
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        for (int i = 0; i < 10; i++) {
            concurrentSkipListMap.put(i, i);
        }
        ConcurrentNavigableMap concurrentNavigableMap = concurrentSkipListMap.tailMap(5);
        concurrentNavigableMap.keySet().stream().forEach(e -> System.out.println(e));
    }


    @Test
    public void testSkipListSet() {
        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();
        for (int i = 0; i < 10; i++) {
            concurrentSkipListSet.add(i);
        }
        concurrentSkipListSet.tailSet(6).stream().forEach(e-> System.out.println(e));
    }
}
