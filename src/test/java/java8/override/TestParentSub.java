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
package java8.override;

import org.junit.Test;

/**
 * 9/22/22 10:24
 * aiguoxin 
 * 说明: Single Dispatch 和 Double Dispatch
 * 当前主流的面向对象编程语言(比如，Java、C++、C#)都只支持 Single Dispatch，不支持 Double Dispatch
 */
public class TestParentSub {

    class Parent {
        public void f() {
            System.out.println("i am parent f()");
        }
    }

    class Child extends Parent {
        public void f() {
            System.out.println("i am child f()");
        }
    }

    class SingleDispatchClass {
        public void polymorphismF(Parent parent) {
            parent.f();
        }

        public void overloadF(Parent parent) {
            System.out.println("i am overloadF(Parent parent) ");
        }

        public void overloadF(Child child) {
            System.out.println("i am overloadF(Child child)");
        }
    }

    @Test
    public void testSingleDispatch() {
        SingleDispatchClass singleDispatchClass = new SingleDispatchClass();
        Parent p = new Child();

        /***执行哪个对象的方法，由对象的实际类型决定。 这里p的是实际类型是Child**/
        singleDispatchClass.polymorphismF(p);
//        i am child f()

        /***执行对象的哪个方法，由参数对象的声明类型决定。 这里p的是声明类型是Parent**/
        singleDispatchClass.overloadF(p);
        //      i am overloadF(Parent parent)
    }
}
