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
