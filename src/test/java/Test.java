import org.apache.commons.lang3.StringUtils;

/** 2020/7/8 上午9:58 aiguoxin 说明: */
public class Test {
    public static void main(String[] args) {
        String idCard = "130527*********235";
        if (StringUtils.contains(idCard, "******")) {
            System.out.println("contain");
        }else{
            System.out.println("no contain");
        }
    }
}
