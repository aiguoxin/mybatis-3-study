package tools;

import java.util.LinkedHashMap;
import java.util.Map;

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
    private int capacity;

    public LRUCache(){
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

    public static void main(String[] args) {
        LRUCache<Integer,Integer> cache = new LRUCache<>(5);
        for(int i=0;i<5;i++){
            cache.put(i,i);
        }
        cache.get(0);
        cache.put(6,6);

        cache.entrySet().stream().forEach(e-> System.out.println(e));
    }

}
