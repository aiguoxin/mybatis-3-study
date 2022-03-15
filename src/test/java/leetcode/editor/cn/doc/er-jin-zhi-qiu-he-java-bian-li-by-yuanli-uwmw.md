
### 代码

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int i = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int mod = 0;
        while(i < len1 ||  i < len2){
            if( i< len1 && i <len2){
                int t = arr1[len1-i-1]-'0' + arr2[len2-i-1]-'0'+mod;
                ans.append(t%2);
                mod = t/2;
            }else{
                if(i < len1){
                    int t = arr1[len1-i-1]-'0'+mod;
                    ans.append(t%2);
                    mod = t/2;
                }
                if(i < len2){
                    int t = arr2[len2-i-1]-'0'+mod;
                    ans.append(t%2);
                    mod = t/2;
                }
            }
            i++;
        }
        if(mod != 0){
            ans.append(mod);
        }
        return ans.reverse().toString();
    }
}
```