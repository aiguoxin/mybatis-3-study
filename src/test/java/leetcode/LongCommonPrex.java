package leetcode;

/**
 * 2021/1/22 下午7:45 aiguoxin 说明:
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 */
public class LongCommonPrex {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    //横向查找
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1 || strs.length > 200) {
            return "";
        }
        String common = strs[0];
        for(int i= 1; i< strs.length; i++){
            common = findCommon(common,strs[i]);
            if(common.length() == 0){
                break;
            }
        }
        return common;
    }

    private static String findCommon(String common, String str) {
        int length = Math.min(common.length(),str.length());
        int idx = 0;
        while(idx < length){
            if(common.charAt(idx) == str.charAt(idx)){
                idx ++;
            }else{
                break;
            }
        }
        return common.substring(0,idx);
    }
}
