package java8;

import java.math.BigDecimal;
import org.junit.Test;

/**
 * 9/27/22 16:18
 * aiguoxin 
 * 说明:
 */
public class BigDecimalTest {
    @Test
    public void testMultiply(){
        System.out.println(BigDecimal.valueOf(60942).multiply(new BigDecimal("0.05")).setScale(2).intValue());
        System.out.println(BigDecimal.valueOf(44460).multiply(new BigDecimal("0.3")).setScale(2).intValue());
    }
}
