/**
 *    Copyright 2009-2022 the original author or authors.
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
package leetcode.array;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;

/**
 * 11/9/22 16:41
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/shortest-completing-word/
 *
 */
public class ShortestWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<String, int[]> countMap = new LinkedHashMap<>();
        int[] plate = new int[26];
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                plate[ch - 'a']++;
            }
        }

        for (String word : words) {
            int[] sArr = new int[26];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.toLowerCase().charAt(j);
                if (ch >= 'a' && ch <= 'z') {
                    sArr[ch - 'a'] ++;
                }
            }
            countMap.put(word,sArr);
        }

        final int[] length = {15};
        AtomicReference<String> result = new AtomicReference<>("");
        countMap.entrySet().stream().forEach(e->{
            boolean flag = true;
            for(int i=0;i<plate.length;i++){
                if(plate[i] > e.getValue()[i]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                if(e.getKey().length() < length[0]){
                    length[0] = e.getKey().length();
                    result.set(e.getKey());
                }
            }
        });

        return result.get();
    }

    @Test
    public void test() {
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord("1s3 PSt", words));
    }
}
