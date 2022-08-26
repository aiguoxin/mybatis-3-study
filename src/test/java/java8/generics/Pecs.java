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

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/1/30 上午11:11
 * aiguoxin
 * 说明:
 * 注意PECS原则，作用于方法的参数中。
 */
public class Pecs {

    class Parent {

    }

    class Child extends Parent {

    }

    public void test() {
        /**编译报错，泛型不存在继承关系**/
//        List<Parent> list = new ArrayList<Child>();

        List<? extends Parent> list = new ArrayList<Child>();
        Parent p = list.get(0);
        //这样会报错，如果存入了父类，不知道要转换成哪个子类
//        list.add(new Parent());

        List<? super Child> childList = new ArrayList<Object>();
        //这样报错，不知道取出来转换成哪个父类
//        Child a = childList.get(0);
        childList.add(new Child());
//        childList.add(new Parent());

        /**通配符没有上下界，无法进行add和get Child操作**/
        List<?> alist = new ArrayList<Child>();
//        alist.add(new Child());
//        Child c = alist.get(0);

        /***************以上都是声明对象使用extends或super，和PECS原则（方法参数）有区别*******************/


        /*******协变Covariance与逆变Contravariance********/
//        Collections.copy(); 用法参考
    }
}
