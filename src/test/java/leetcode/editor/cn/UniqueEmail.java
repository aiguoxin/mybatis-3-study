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
