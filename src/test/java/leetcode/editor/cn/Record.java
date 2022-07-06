package leetcode.editor.cn;

/**
 * 7/6/22 08:08
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/student-attendance-record-i/
 */
public class Record {

    public boolean checkRecord(String s) {
        int countA = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countA++;
            }
        }

        return countA < 2 && !s.contains("LLL");
    }

    public static void main(String[] args) {
        Record r = new Record();
        System.out.println(r.checkRecord("PPALLL"));
    }
}
