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
package java8.solid.oc;

/**
 * 2022/4/6 下午4:17
 * aiguoxin 
 * 说明: 开闭原则例子
 */
public class Bad {
    public void doHandler(Adapter adapter){
        if(adapter instanceof AjaxAdapter){
            makeAjaxCall();
        }else if(adapter instanceof NodeAdapter){
            makeNodeCall();
        }
    }

    private void makeNodeCall() {
        //
    }

    private void makeAjaxCall() {
        //
    }
}

abstract class Adapter {

}

class AjaxAdapter extends Adapter{

}

class NodeAdapter extends Adapter{

}
