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
package design.adaptor;

/**
 * 7/27/22 20:36
 * aiguoxin 
 * 说明: CD是外部类，不能修改，包含static方法，不便单测
 * 采用的extends方式
 */
public class CD {
    public static void staticMethod(){

    }
}

interface ITarget{
    void M1();
}

class CDAdaptor extends CD implements ITarget{

    @Override
    public void M1() {
        super.staticMethod();
    }
}
