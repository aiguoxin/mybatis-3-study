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
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 7/26/22 22:16
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/minimum-index-sum-of-two-lists/
 */
public class Resturant {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> l1Map = new HashMap<>();
        Map<String, Integer> resMap = new HashMap<>();
        List<String> resList = new ArrayList();

        for (int i = 0; i < list1.length; i++) {
            l1Map.put(list1[i], i);
        }

        for (int j = 0; j < list2.length; j++) {
            Integer val = l1Map.get(list2[j]);
            if (val == null) {
                continue;
            } else {
                resMap.put(list2[j], val + j);
            }
        }

//        Optional<Integer> op = resMap.values().stream().min(Integer::compareTo);
        final int[] min = {Integer.MAX_VALUE};
        resMap.values().stream().forEach(e -> {
            if (e < min[0]) {
                min[0] = e;
            }
        });

        resMap.entrySet().stream().forEach(e -> {
            if (e.getValue() == min[0]) {
                resList.add(e.getKey());
            }
        });

        System.out.println(resList);
        return resList.toArray(new String[resList.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        System.out.println(findRestaurant(list1, list2));
    }
}
