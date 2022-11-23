package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 11/23/22 13:28
 * aiguoxin
 * 说明: https://leetcode.cn/problems/lru-cache/
 * HashMap + 双向链表
 *
 * 双链表操作技巧：开始用了头尾两个指针。 可以只用一个指针，把整个链表弄个一个环，更好操作！！！！
 */
public class LRUCache {
    private int capacity;
    private DataN last;
    private DataN first;

    public HashMap<Integer, DataN> getDataNHashMap() {
        return dataNHashMap;
    }

    /**** ConcurrentHashMap 更好点****/
    private HashMap<Integer, DataN> dataNHashMap = new HashMap();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DataN dataN = dataNHashMap.get(key);
        if (dataN != null) {
            shift2Last(dataN);
            return dataN.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        DataN dataN = dataNHashMap.get(key);

        if (dataN == null) {
            if (dataNHashMap.size() >= capacity) {
                removeFirst(first);
            }

            //新增加点，放到最后一个
            DataN newData = new DataN();
            newData.setKey(key);
            newData.setValue(value);

            if (dataNHashMap.size() == 0) {
                last = newData;
                first = newData;
            } else {
                newData.setPre(last);
                last.setNext(newData);
                last = newData;
            }
            dataNHashMap.put(key, newData);
        } else { //存在，则移动到最后
            /***可能key相同，value不同！！**/
            dataN.setValue(value);
            shift2Last(dataN);
        }
    }

    private void shift2Last(DataN dataN) {
        if (dataN != last) {
            DataN preNode = dataN.pre;
            DataN nextNode = dataN.next;

            nextNode.pre = preNode;
            /**NPE**/
            if (preNode != null) {
                preNode.next = nextNode;
            }

            dataN.pre = last;
            last.next = dataN;
            last = dataN;

            if (dataN == first) {
                first = nextNode;
            }
        }
    }

    private void removeFirst(DataN firstNode) {
        dataNHashMap.remove(firstNode.getKey());
        DataN nextData = firstNode.next;
        /**NPE**/
        if (nextData != null) {
            nextData.pre = null;
        }
        firstNode.next = null;

        first = nextData;
    }

    private class DataN {
        private int key;
        private int value;
        private DataN next;
        private DataN pre;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public DataN getNext() {
            return next;
        }

        public void setNext(DataN next) {
            this.next = next;
        }

        public DataN getPre() {
            return pre;
        }

        public void setPre(DataN pre) {
            this.pre = pre;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.dataNHashMap.entrySet().stream().forEach(e -> System.out.println(e.getValue().getKey() + ":" + e.getValue().getValue()));
    }
}
