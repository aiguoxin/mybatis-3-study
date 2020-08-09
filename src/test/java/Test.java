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
