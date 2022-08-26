/**
 *    Copyright 2009-2021 the original author or authors.
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
package leetcode.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2021/12/10 下午2:27
 * aiguoxin
 * 说明: debug java Collections.sort
 * TimSort 排序：二分插入排序 + 合并排序（合并run，普通合同排序优化）
 */
public class JavaSortTest {

    public static void main(String[] args) {

        List<Integer> list =  Arrays.asList(1,3,2,4,5,6);
        Collections.sort(list);
        list.forEach(d->System.out.println(d));
    }
}
