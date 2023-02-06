package leetcode.array;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.cn/problems/find-common-characters/
 *
 * 其他思路：使用大小26的数组，更新每个字母的最小值，最后遍历数组大于0的即可。
 */
public class CommonChar {
    public List<String> commonChars(String[] words) {
        if(words.length < 2){
            return new ArrayList<>();
        }
        List<Map<Character,Integer>> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            Map<Character,Integer> map = new HashMap<>();
            String word = words[i];
            for(int j=0;j<word.length();j++){
                Character ch = word.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            list.add(i,map);
        }

        List<String> res = new ArrayList<>();
        Map<Character,Integer> firstMap = list.get(0);
        for(Map.Entry<Character,Integer> entry: firstMap.entrySet()){
            Character ch = entry.getKey();
            int count = entry.getValue();
            boolean flag = true;
            for(int k=1;k<list.size();k++){
                if(list.get(k).get(ch) == null){
                    flag = false;
                    break;
                }else{
                    count = Math.min(count,list.get(k).get(ch));
                }
            }
            if(flag){
                for(int i=0;i<count;i++) {
                    res.add(ch + "");
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        String[] words = {"bella","label","roller"};
        System.out.println(commonChars(words));
    }
}
