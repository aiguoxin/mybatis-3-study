### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public boolean isValid(String s) {
        int l=s.length();
       for(int i=0;i<l;i++){
	          s= s.replace("()","").replace("{}","").replace("[]","");
	       }
	     // System.out.println(s.length());
	       return s.length()==0;

	    }
    }

```