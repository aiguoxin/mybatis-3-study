package java8.concurrent;

import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

/**
 * 11/29/22 19:02
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/design-skiplist/
 * 如何确定开始有几层level？
 * ---最大32层，初始化0层，新增一个元素，根据随机数level，层数递增，但不会大于32
 *
 * 查找：最高level查找，没找到，降低level找；不同level中的同一个元素，如何快速定位？
 * ---涉及到数据节点结构：int value，DataNode[]下一个节点数组（数组大小是最大max），多个指针
 *
 * 新增元素：找到位置，插入元素后，其他level是否需要维护新增？
 * ---需要一个update数组，元素是DataNode类型，存储的是每个level查找元素经过的节点值
 *
 * 移除元素：找到第一个移除掉，level如何更新？
 * ---先查找元素是否存在，不存在，直接false。存在，
 * 1）则根据update数组，更新0 level指针删除当前元素。
 * 2）遍历update数组，如果有，需更新每个level指针
 * 3）遍历每层level，如果该level没元素了，则level需要减掉。也就是level记录的是当前实际的层数
 */
public class Skiplist {
    //最多32个level
    int maxLevel = 32;
    //当前最大level
    int currentMaxLevel;
    //用于保存每层的节点，则查找路线节点
    DataNode[] update;
    //头节点
    DataNode head;
    Random random = new Random();

    public Skiplist() {
        this.currentMaxLevel = 0;
        head = new DataNode(-1, maxLevel);
    }

    public boolean search(int target) {
        //从最上层开始找
        DataNode currentNode = head;
        for (int i = currentMaxLevel - 1; i >= 0; i--) {

//            if (currentNode.nextNodes[i] != null && currentNode.nextNodes[i].value < target) {  需要while不断找到下一个
            while (currentNode.nextNodes[i] != null && currentNode.nextNodes[i].value < target) {
                currentNode = currentNode.nextNodes[i];
            }
        }

        //不能漏了判空
        if (currentNode.nextNodes[0] != null && target == currentNode.nextNodes[0].value) {
            return true;
        }
        return false;
    }

    public void add(int num) {
        update = new DataNode[maxLevel];
//        Arrays.fill(update,new DataNode(-1,maxLevel)); 这样不行，需要默认head放里面！！
        Arrays.fill(update, head);

        //从最上层开始找
        DataNode currentNode = head;
        for (int i = (currentMaxLevel - 1); i >= 0; i--) {
            while (currentNode.nextNodes[i] != null && currentNode.nextNodes[i].value < num) {
                currentNode = currentNode.nextNodes[i];
            }
            update[i] = currentNode;
        }

        int level = selectLevel();
        currentMaxLevel = Math.max(level, currentMaxLevel);
        DataNode newNode = new DataNode(num, maxLevel);

        for (int i = 0; i < currentMaxLevel; i++) {
            newNode.nextNodes[i] = update[i].nextNodes[i];
            update[i].nextNodes[i] = newNode;
        }

    }

    private int selectLevel() {
        int level = 1;
        while (random.nextDouble() < 0.25 && level < maxLevel) {
            level++;
        }
        return level;
    }

    public boolean erase(int num) {
        update = new DataNode[maxLevel];
        Arrays.fill(update, head);

        int level = selectLevel();
        currentMaxLevel = Math.max(level, currentMaxLevel);

        //从最上层开始找
        DataNode currentNode = head;
        for (int i = currentMaxLevel - 1; i >= 0; i--) {
            while (currentNode.nextNodes[i] != null && currentNode.nextNodes[i].value < num) {
                currentNode = currentNode.nextNodes[i];
            }
            update[i] = currentNode;
        }

        DataNode findNode;
        if (currentNode.nextNodes[0] != null && num == currentNode.nextNodes[0].value) {
            findNode = currentNode.nextNodes[0];
        } else {
            return false;
        }

        //移除level中的索引
        for (int i = 0; i < currentMaxLevel; i++) {
            if (update[i].nextNodes[i] != findNode) {
//                continue; 从最底层向上，如果底层没有，那上一层更没有！！
                break;
            }
            update[i].nextNodes[i] = findNode.nextNodes[i];
        }
        //更新最大level
        while (currentMaxLevel > 1 && head.nextNodes[currentMaxLevel - 1] == null) {
            currentMaxLevel--;
        }

        return true;
    }

    class DataNode {
        int value;
        DataNode[] nextNodes;

        public DataNode(int value, int level) {
            this.value = value;
            this.nextNodes = new DataNode[level];
        }
    }

    @Test
    public void test() {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));

        skiplist.add(4);
        System.out.println(skiplist.search(1));
        skiplist.add(5);
        System.out.println(skiplist.search(3));
        System.out.println(skiplist.search(6));
    }

}
