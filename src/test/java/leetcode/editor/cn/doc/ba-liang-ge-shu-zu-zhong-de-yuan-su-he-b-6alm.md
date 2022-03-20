### 解题思路
首先定义一个数组，再定义三个游标，分别代表nums1,nums2和sorted数组的下标。当i<nums1.length和j<nums2.length的时候，开始比较两个数组中谁的值小，谁的值小就先放进sorted中，比完之后，肯定会有nums1数组剩下或者nums2剩下的情况，之后将剩下的数组元素再依次放入sorted中。

### 代码

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []sorted =new int[m+n];
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(nums1[i]<nums2[j])
                sorted[k++]=nums1[i++];
            else
                sorted[k++]=nums2[j++];
        }
        while(i<m){
            sorted[k++]=nums1[i++];
        }
        while(j<n){
            sorted[k++]=nums2[j++];
        }
        for( i=0;i<m+n;i++){
            nums1[i]=sorted[i];
        }

    }
}
```