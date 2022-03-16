#### [69. Sqrt(x)](https://leetcode-cn.com/problems/sqrtx/)（easy）

##### 方法1:二分法

- 思路：从0-x不断二分，直到
- 复杂度分析：时间复杂度`O(logx)`，即为二分查找需要的次数。空间复杂度`O(1)`



js:

```js
var mySqrt = function (x) {
    let left = 0
    let right = x
    while (left <= right) {
        let mid = left + ((right - left) >> 1)//中间位置索引 x>>1 表示除以2并取整，缩小一下遍历的范围
        if (mid * mid <= x) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return right
};

```

Java:

```java
class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

```



##### 方法2:牛顿迭代

- 思路：`r = ( r + x / r ) / 2`
- 复杂度分析：时间复杂度`O(logx)`。空间复杂度`O(1)`



js:

```js
var mySqrt = function(x) {
    let r = x

    while (r ** 2 > x) r = ((r + x / r) / 2) | 0//取整

    return r
};
```

Java:

```java
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        double l = 0;
        double r = 1;
        while (l != r) {
            l = r;
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
}
```

#### 视频教程（高效学习）:[点击学习](https://xiaochen1024.com/series/6196129fc1553b002e57bef5/6196208ec1553b002e57bef6)

#### 目录：

[1.开篇介绍](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18)

[2.时间空间复杂度](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/619635dcc1553b002e57bf12)

[3.动态规划](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/61963bcdc1553b002e57bf13)

[4.贪心](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/61963ce5c1553b002e57bf14)

[5.二分查找](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/61963e36c1553b002e57bf15)

[6.深度优先&广度优先](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/61964050c1553b002e57bf16)

[7.双指针](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/619640cec1553b002e57bf17)

[8.滑动窗口](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/61964164c1553b002e57bf18)

[9.位运算](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196420ac1553b002e57bf19)

[10.递归&分治](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/61964285c1553b002e57bf1a)

[11剪枝&回溯](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/61964326c1553b002e57bf1b)

[12.堆](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/619643e1c1553b002e57bf1c)

[13.单调栈](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196ce3ac1553b002e57bf1f)

[14.排序算法](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196ced6c1553b002e57bf20)

[15.链表](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196cf7fc1553b002e57bf21)

[16.set&map](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196cfc6c1553b002e57bf22)

[17.栈](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196d002c1553b002e57bf23)

[18.队列](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196d065c1553b002e57bf24)

[19.数组](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196d0f9c1553b002e57bf25)

[20.字符串](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196d19cc1553b002e57bf26)

[21.树](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196d279c1553b002e57bf27)

[22.字典树](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196d2c4c1553b002e57bf28)

[23.并查集](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196d34dc1553b002e57bf29)

[24.其他类型题](https://xiaochen1024.com/courseware/60b4f11ab1aa91002eb53b18/6196d3adc1553b002e57bf2a)