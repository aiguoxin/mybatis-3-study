/**
 *    Copyright 2009-2021 the original author or authors.
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
package leetcode; /**
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
/**
 * 2020/8/12 上午9:18
 * aiguoxin
 * 说明: 快速排序，递归实现
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] sortArray = new int[]{6, 3, 1, 2, 5, 7};
        quickSort(sortArray,sortArray.length-1);
        for (int i = 0; i < sortArray.length; i++) {
            System.out.println(sortArray[i]);
        }
    }

    public static void quickSort(int[] sortArray,int length){
        quickSortChild(sortArray, 0, length);
    }

    private static void quickSortChild(int[] sortArray, int p, int r) {
        if(p >= r){
            return;
        }
        int q = partitionBySwap(sortArray, p ,r);
        quickSortChild(sortArray, p, q-1);
        quickSortChild(sortArray, q+1, r);
    }

    /**
     * 临时申请两个数组
     * @param sortArray
     * @param p
     * @param r
     * @return
     */
    private static int partitionByExtra(int[] sortArray, int p, int r) {
        int[] tmpMin = new int[r+1];
        int[] tmpMax = new int[r+1];
        //处理sortArray
        int compareVal = sortArray[r];
        int j = 0;
        int k = 0;
        for(int i=p;i<r;i++){
            if(sortArray[i]<=compareVal){
                tmpMin[j] = sortArray[i];
                j ++;
            }else{
                tmpMax[k] = sortArray[i];
                k++;
            }
        }
        System.arraycopy(tmpMin,0,sortArray,p,j);
        sortArray[p+j] = compareVal;
        System.arraycopy(tmpMax,0,sortArray,p+j+1, k);

        return p+j;
    }

    //todo 使用原地排序，不是用额外空间，通过元素交换
    private static int partitionBySwap(int[] sortArray, int p, int r){
        int compareVal = sortArray[r];
        int currPos = r;

        for(int i=p; i<r; i++){
            if((sortArray[i] > compareVal && currPos > i) || (sortArray[i]<= compareVal && currPos < i)){
                //交换
                int tmp = sortArray[currPos];
                sortArray[currPos] = sortArray[i];
                sortArray[i] = tmp;
                currPos = i;
            }
        }
        //返回compareVal的位置
        return currPos;
    }
}
