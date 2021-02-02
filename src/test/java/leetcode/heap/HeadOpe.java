/**
 *    Copyright 2009-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package leetcode.heap;

/** 2020/8/15 上午10:43 aiguoxin 说明: 堆基本操作：插入、移除，属于完全二叉树，数组下标从1开始 备注：jdk中是如何实现的呢？ */

/**
 * 堆特点：1、完全二叉树  2、节点大于子节点，并不要求右节点>左节点
 */
public class HeadOpe {
    private int[] array;
    private int count; // 数组当前元素个数
    private int length; // 数组长度

    public HeadOpe(int capacity) {
        array = new int[capacity];
        count = 0;
        length = capacity;
    }

    public static void main(String[] args) {
        HeadOpe headOpe = new HeadOpe(1000);
        headOpe.insert(3);
        headOpe.insert(2);
        headOpe.insert(5);
        headOpe.insert(7);
        headOpe.insert(1);
        System.out.println("max data is:" + headOpe.array[1]);
        System.out.println("remove data is:" + headOpe.removeByTemp());
        System.out.println("max data is:" + headOpe.array[1]);
        System.out.println("remove data is:" + headOpe.removeByTemp());
        System.out.println("max data is:" + headOpe.array[1]);
    }

    /** 大堆 插入新元素，自下往上堆化 */
    public void insert(int newData) {
        if (count == length) {
            throw new RuntimeException("add new data failed");
        }
        count++;
        array[count] = newData;

        int i = count;
        while (i / 2 > 0 && array[i / 2] < array[i]) {
            swapArrayData(array, i, i / 2);
            i = i / 2;
        }
    }

    /** 移除堆顶元素，从上往下堆化 */
    public int remove() {
        if (count == 0) {
            throw new RuntimeException("no data");
        }
        int removeData = array[1];
        array[1] = array[count];
        count--;

        int i = 1;
        while (true) {
            if (i * 2 < length && array[i * 2] > array[i]) {
                swapArrayData(array, i, i * 2);
                i = i * 2;
            }

            if (i * 2 + 1 < length && array[i * 2 + 1] > array[i]) {
                swapArrayData(array, i, i * 2 + 1);
                i = i * 2 + 1;
            }

            if (array[i * 2] < array[i] && array[i * 2 + 1] < array[i]) {
                break;
            }
            if (i * 2 >= count || (i * 2 + 1) >= count) {
                break;
            }
        }

        return removeData;
    }

    /**
     * 更优化，先找到交换的位置，最后交换
     * @return
     */
    public int removeByTemp() {
        if (count == 0) {
            throw new RuntimeException("no data");
        }
        int removeData = array[1];
        array[1] = array[count];
        count--;

        int i = 1;
        while (true) {
            int maxPos = i;
            if(i*2 <= count && array[i*2] > array[i]){
                maxPos = i*2;
            }
            if(i*2+1 <= count && array[i*2+1] > array[maxPos]){
                maxPos = i*2+1;
            }
            if (maxPos == i) {
                break;
            }

            swapArrayData(array,i,maxPos);

            i = maxPos;
        }
        return removeData;
    }

    private void swapArrayData(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
