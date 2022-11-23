package tools;

import java.util.LinkedList;

/**
 * 11/22/22 13:09
 * aiguoxin 
 * 说明: LRU实现
 * TODO：看看开源框架如何实现的
 * 1）extends LinkedHashMap，重写removeEldestEntry即可
 * 2）使用HashMap+双向联表实现，TODO
 * HashMap<K,Entry<K,V>>
 * Entry<K,V>{
 *     Entry pre;
 *     Entry next;
 *     K key;
 *     V value;
 * }
 * 3）如何实现缓存序列化呢？
 */
public class LRU<K,V> {
    private Long max;

    public LinkedList<DataNode<K, V>> getList() {
        return list;
    }

    private LinkedList<DataNode<K,V>> list;

    public LRU(Long max){
        this.max = max;
        list = new LinkedList<>();
    }


    public boolean put(K k,V v){
        boolean exist = false;
        //如果size>max，淘汰最后一个
        if(list.size() == max){
            list.removeFirst();
        }

        DataNode node = new DataNode(k,v);
        //list是空
        if(list.isEmpty()) {
            list.add(node);
            return true;
        }

        //list非空，判断是否已存在
        for(DataNode dataNode : list){
            if(dataNode.getK() == k){
                exist = true;
                break;
            }
        }

        //新建一个list，新加入的放第一个，依次加入剩下的
        if(exist){
            LinkedList<DataNode<K,V>> newList = new LinkedList<>();
            for(DataNode dataNode : list){
                if(dataNode.getK() == k){
                   continue;
                }
                newList.add(dataNode);
            }
            newList.add(node);
            list = newList;
        }else{
            list.add(node);
        }

        return true;
    }



    public V get(K k){
        for(DataNode dataNode : list){
            if(dataNode.getK() == k){
                //查看过的，得放到一个节点
                LinkedList<DataNode<K,V>> newList = new LinkedList<>();
                for(DataNode node : list){
                    if(node.getK() == k){
                        continue;
                    }
                    newList.add(node);
                }
                newList.add(dataNode);
                list = newList;
                return (V)dataNode.getV();
            }
        }
        return null;
    }

    private class DataNode<K, V> {
        private K k;

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        private V v;
        public DataNode(K k,V v) {
            this.k = k;
            this.v = v;
        }

    }

    public static void main(String[] args) {
        LRU<Integer,Integer> lru = new LRU<>(10L);
        for(int i=0;i<10;i++){
            lru.put(i,i);
        }
        lru.get(5);
        lru.put(10,10);
        lru.getList().stream().forEach(data-> System.out.println(data.getK()+":"+data.getV()));

    }
}
