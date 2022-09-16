package java8.generics;

import java.util.function.Function;
import org.junit.Test;

/**
 * 9/16/22 09:54
 * aiguoxin 
 * 说明:
 */
public class FunctionTest {

    @Test
    public void testMethod() {
        Function<Integer, Integer> multiplyTen = a -> a * 10;
        System.out.println(multiplyTen.apply(5));

        Function<Integer, Integer> addTen = a -> a + 10;

        Function<Integer,Integer> addTenThenMultiplyTen = multiplyTen.compose(addTen);
        System.out.println(addTenThenMultiplyTen.apply(1)); //110

        Function<Integer,Integer> multiplyTenAddTenThen = multiplyTen.andThen(addTen);
        System.out.println(multiplyTenAddTenThen.apply(1)); //20

        Function<Integer,Integer> multiplyTenAddTenThenOther = addTen.compose(multiplyTen);
        System.out.println(multiplyTenAddTenThenOther.apply(1)); //20

    }


    @Test
    public void testCheck(){
         CheckUtils.lengthCheck.apply("a");
    }

    static class CheckUtils{
        public static final Function<String,String> lengthCheck = params ->{
            if(params.length() > 1){
                throw new RuntimeException("length exceed max limit.");
            }
            return params;
        };
    }

}
