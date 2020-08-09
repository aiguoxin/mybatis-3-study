/**
 *    Copyright 2009-2020 the original author or authors.
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
package study.bytecode;

import com.sun.tools.attach.VirtualMachine;

/**
 * 2020/8/9 上午10:55
 * aiguoxin
 * 说明:
 */
public class Attacher {
    public static void main(String[] args) throws Exception{
        VirtualMachine vm = VirtualMachine.attach("27923");
        vm.loadAgent("/Volumes/work/qiyi/git/renzheng-biz-support/target/renzheng-biz-support-1.0.0-SNAPSHOT.jar");
    }
}
