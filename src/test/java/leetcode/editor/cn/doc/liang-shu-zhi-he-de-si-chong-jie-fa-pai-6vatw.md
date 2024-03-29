# 1-两数之和

[leetcode #1-两数之和 (简单)](https://leetcode-cn.com/problems/two-sum/)

> 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
>
> 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
>
> 你可以按任意顺序返回答案。
>
> 提示：
>
> 2 <= nums.length <= 104
> -109 <= nums[i] <= 109
> -109 <= target <= 109
> 只会存在一个有效答案

## 解法一：暴力搜索

### 算法描述

两个循环，第一个循环从前到后取出一个数nums[i]，第二个循环寻找target - nums[i]是否在剩下的元素中。

### 时空复杂度

时间复杂度为O(n^2)。不考虑原数组的情况下，空间复杂度为O(1)。

### 代码

```java
public int[] twoSumBrute(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if(nums[j] == target - nums[i]) {
                return new int[] {i, j};
            }
        }
    }
    return new int[] {};
}
```



## 解法二：哈希表1

### 算法描述

将原数组元素值(key)和其下标(value)存入一张哈希表后，用一个循环遍历nums，以O(1)时间复杂度在哈希表中寻找map.containsKey(target - nums[i])。

### 时空复杂度

将原数组存入哈希表花费O(n)时间，循环遍历花费O(n)时间，哈希表每次定位只花费O(1)时间，所以时间复杂度为O(n)。

哈希表消耗空间为O(n)，所以空间复杂度为O(n)。

### 代码

```java
 public int[] twoSumHash1(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int n1 = target - nums[i];
        if(map.containsKey(n1)) {
            if(i != map.get(n1)) {
                return new int[] {i, map.get(n1)};
            }
        }
    }
    return new int[] {};
}
```



## 解法三：哈希表2

### 算法描述

在哈希表1算法中，拷贝了完整的原数组到哈希表中，在哈希表中查找target - nums[i]时，会基于完整的数据查找。可以不直接拷贝原数组到哈希表中，而是在遍历nums查找哈希表时，找不到再put(K,V)，找到则立即返回结果。采用这样的方式能够节省哈希表的空间，且减少空间的同时也削减了计算哈希值的耗时。

### 时空复杂度

时间复杂度取决于遍历原数组耗时，为O(n)。使用了哈希表存储数组内容，空间复杂度O(n)。

### 代码

```java
public int[] twoSumHash2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int n0 = nums[i];
        int n1 = target - n0;
        if(map.containsKey(n1)) {
            return new int[] {i, map.get(n1)};
        }
        else {
            map.put(n0, i);
        }
    }
    return new int[] {};
}
```



## 解法四：哈希表3

### 算法描述

在哈希表2的基础上仍可改进，即每次在哈希表中搜索补数时，设置left和right两个指针，一次搜索nums中左右两端的元素的补数，可以得到耗时0ms的效果。

![](https://pic.leetcode-cn.com/1633402163-hiTloS-008i3skNgy1gv3hevif3yj60qu0803z602.jpg)

### 时空复杂度

时间复杂度取决于遍历原数组耗时，为O(n)。使用了哈希表存储数组内容，空间复杂度O(n)。

### 代码

```java
public int[] twoSumHash3(int[] nums, int target) {
    if(nums == null || nums.length < 2) {
        return new int[] {};
    }
    Map<Integer, Integer> map = new HashMap<>();
    int left = 0;
    int right = nums.length - 1;
    while(left <= right) {
        int ln0 = nums[left];
        int rn0 = nums[right];
        int ln1 = target - ln0;
        int rn1 = target - rn0;
        if(map.containsKey(ln1)) {
            return new int[] {left, map.get(ln1)};
        }
        else {
            map.put(ln0, left++);
        }
        if(map.containsKey(rn1)) {
            return new int[] {right, map.get(rn1)};
        }
        else {
            map.put(rn0, right--);
        }
    }
    return new int[] {};
}
```



## 解法五：排序后折半查找

### 算法描述

先将元素nums拷贝一份为copiedNums，然后将原数组排序，接着遍历排序后的数组，以遍历到的数字之后的数列执行折半查找，查找目标为target - nums[i]。因为原数组排序后丢失原下标信息，因此执行折半查找得到n0和n1(n0 + n1 = target)后，再遍历两次copiedNums分别得到n0和n1在copiedNums中的下标(原下标)。排序和折半查找可以调用Arrays静态方法Arrays.sort()和Arrays.binarySearch()，也可以自己实现。代码示例中排序用Arrays.sort()，折半查找用自己实现的版本。

### 时空复杂度

排序耗时O(nlogn)(假设采用O(nlogn)的排序算法)，拷贝原数组耗时O(n)，排序后的折半查找耗时为O(logn)，最后找原下标的两个for均耗时O(n)，所以总体时间复杂度为O(nlogn)。

空间复杂度为O(n)。

### 代码

```java
public int[] twoSumSortBinarySearch(int[] nums, int target) {
    int[] res = new int[2];
    int[] resVal = new int[2];
    int[] copiedNums = Arrays.copyOf(nums, nums.length);
    Arrays.sort(nums);
    int n1 = -1;
    for (int i = 0; i < nums.length; i++) {
        resVal[0] = nums[i];
        resVal[1] = target - resVal[0];
        // 也可以用Arrays自带的折半查找方法Arrays.binarySearch()，
        // 但要注意判断返回值的地方要做相应修改。
        // n1 = Arrays.binarySearch(nums, i + 1, nums.length -1 , resVal[1]);
        n1 = binarySearchBasic(nums, i + 1, resVal[1]);
        if(n1 != -1) {
            break;
        }
    }
    if(n1 == -1) {
        return new int[] {};
    }
    for (int j = 0; j < copiedNums.length; j++) {
        if(copiedNums[j] == resVal[0]) {
            res[0] = j;
            break;
        }
    }
    for (int k = 0; k < copiedNums.length; k++) {
        // 注意不能是同一个元素，需加上 k != res[0] 条件
        if(copiedNums[k] == resVal[1] && k != res[0]) {
            res[1] = k;
            break;
        }
    }
    return res;
}

private int binarySearchBasic(int[] arr, int low, int target) {
    int high = arr.length - 1;
    while(low <= high) {
        int center = (low + high) / 2;
        if(target == arr[center]) {
            return center;
        }
        else if(target < arr[center]) {
            high = center - 1;
        }
        else {
            low = center + 1;
        }
    }
    return -1;
}
```



## 解法六：数据封装+排序后折半查找

### 算法描述

与解法五类似，也是对原数组先排序，再执行折半查找，但用一个新的类NumWithIndex封装原数组元素的值和其下标。将原数组拷贝到这个NumWithIndex的数组中，再排序此数组。因为NumWithIndex数组元素携带了原始下标，所以执行折半查找得到“两数”后，可直接输出下标，而无需像解法三一样再用两个for来寻找原下标。排序和折半查找可以调用Arrays静态方法Arrays.sort()和Arrays.binarySearch()，也可以自己实现。代码示例中排序用Arrays.sort()，折半查找用自己实现的版本。

注意：如果排序或者折半查找采用内置的Arrays静态，则必须令NumWithIndex实现Comparable接口并正确重写compareTo方法。

### 时空复杂度

排序耗时O(nlogn)(假设采用O(nlogn)的排序算法)，拷贝原数组耗时O(n)，排序后的折半查找耗时为O(logn)，所以总体时间复杂度为O(nlogn)。

空间复杂度为O(n)。

### 代码

```java
public int[] twoSumSortBinarySearchWithIndex(int[] nums, int target) {
    NumWithIndex[] numWithIndexs = new NumWithIndex[nums.length];
    for (int i = 0; i < nums.length; i++) {
        numWithIndexs[i] = new NumWithIndex(nums[i], i);
    }
    Arrays.sort(numWithIndexs);
    for (int i = 0; i < numWithIndexs.length; i++) {
        int index1 = numWithIndexs[i].index;
        int index2 = binarySearchBasic(numWithIndexs, i + 1, target - numWithIndexs[i].num);
        if(index2 != -1) {
            return new int[] {index1, index2};
        }
    }
    return new int[] {};
}

/**
 * 针对NumWithIndex数组的折半查找
 * 若数组中存在其num字段为target的元素，返回其index字段，否则返回-1
 */
private int binarySearchBasic(NumWithIndex[] arr, int low, int target) {
    int high = arr.length - 1;
    while(low <= high) {
        int center = (low + high) / 2;
        if(target == arr[center].num) {
            return arr[center].index;
        }
        else if(target < arr[center].num) {
            high = center - 1;
        }
        else {
            low = center + 1;
        }
    }
    return -1;
}

/**
 * 内部类，将数组中的数字及其原始下标封装起来
 */
private class NumWithIndex implements Comparable<NumWithIndex>{
    private int num;
    private int index;

    public NumWithIndex(int num, int index) {
        this.num = num;
        this.index = index;
    }

    // 重写compareTo方法，使本类支持Arrays.sort()
    @Override
    public int compareTo(NumWithIndex obj) {
        if(this.num > obj.num) {
            return 1;
        }
        else if(this.num < obj.num) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
```
