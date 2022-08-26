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

import java.util.HashSet;
import java.util.Set;

/**
 * 8/23/22 07:36
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/unique-email-addresses/
 */
public class UniqueEmail {
    public static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String[] localStrArray = email.split("@");
            String localStr = localStrArray[0].replaceAll("\\.", "");
            int idx = localStr.indexOf("+");
            if(idx != -1) {
                localStr = localStr.substring(0, idx);
            }
            emailSet.add(localStr+"@"+localStrArray[1]);
        }
        System.out.println(emailSet);
        return emailSet.size();
    }

    public static void main(String[] args) {
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
