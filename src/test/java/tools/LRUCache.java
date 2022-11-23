package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 11/23/22 10:08
 * aiguoxin 
 * 说明: 基于LinkHashMap实现
 * 关键点：
 * 1. 设置accessOrder=true
 * 2. 重写removeEldestEntry()
 * 3. 使用hook机制，退出的时候，序列化到磁盘中todo
 */
public class LRUCache<K, V> extends LinkedHashMap {
    private static String filePath = "/Users/liuruixue/Downloads/cache.txt";
    private int capacity;

    public LRUCache() {
        this(16);
    }

    public LRUCache(int capacity) {
        /***一定需要这句，设置accessOrder=true才会维护顺序**/
        super(capacity, 0.75F, true);
        this.capacity = capacity;

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        /**调用size()更简单**/
//        return super.entrySet().size() > capacity;
        return super.size() > this.capacity;
    }

    public static void main(String[] args) throws Exception {


        LRUCache<Integer, Integer> cache = new LRUCache<>(5);
        for (int i = 0; i < 5; i++) {
            cache.put(i, i);
        }
        cache.get(0);
        cache.put(6, 6);

//        cache.entrySet().stream().forEach(e-> System.out.println(e));

        Set<Entry> set = cache.entrySet();
        for (Map.Entry entry : set) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        /***测试hook机制及序列化到本地***/
        Runtime.getRuntime().addShutdownHook(new Hook(cache));
    }

    static class Hook extends Thread {
        private LRUCache cache;

        public Hook(LRUCache cache) {
            this.cache = cache;
        }

        @Override
        public void run() {
            System.out.println("start to shutdown ...");
            //序列化到本地
            try {
                //序列化
                OutputStream out = new FileOutputStream(new File(filePath));
                ObjectOutputStream outputStream = new ObjectOutputStream(out);
                outputStream.writeObject(cache);
                outputStream.close();

                //反序列化
                InputStream inputStream = new FileInputStream(new File(filePath));
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                LRUCache<Integer, Integer> cache = (LRUCache<Integer, Integer>) objectInputStream.readObject();
                objectInputStream.close();

                cache.entrySet().stream().forEach(e -> System.out.println(e));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("finish to shutdown ...");
        }

    }
}
