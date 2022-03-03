### 解题思路
此处撰写解题思路
![搜狗截图20220228154414.png](https://pic.leetcode-cn.com/1646034284-GZROKu-%E6%90%9C%E7%8B%97%E6%88%AA%E5%9B%BE20220228154414.png)
### 代码
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int l = strs[0].length();
        for(String str : strs){
            l = Math.min(l,str.length());
        }
        for(int i=0;i<l;i++){
            char c = strs[0].charAt(i);
            for(String str : strs){
                if(str.charAt(i) != c){
                    return str.substring(0,i);
                }
            }
        }
        return strs[0].substring(0,l);
    }
}
```