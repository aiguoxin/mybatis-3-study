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
package design;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 7/17/22 12:46
 * aiguoxin 
 * 说明: java浅拷贝与深拷贝test
 */
public class CopyTest {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.id = 1;
        user.name = "shallow copy";
        User subUser = new User();
        subUser.name = "subUser";
        user.subUser = subUser;

        User newUser = (User) user.clone();
        newUser.name = "new name";
//        newUser.subUser.name = "new subUser name";

        //浅拷贝：基本类型及引用地址的copy，所以newUser.name改变了name，不会影响原始数据
        System.out.println(user.name);
        //深拷贝：没有深拷贝，改了拷贝的内容，会影响原始内容
        System.out.println(user.subUser.name);


        User deepUser = (User) user.deepCopy(user);
        //此处是深拷贝，不会改变原始数据
        deepUser.subUser.name = "new deep name";
        System.out.println(user.subUser.name);
    }


    static class User implements Cloneable, Serializable {
        private int id;
        private String name;
        private User subUser;

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /**
         * 深拷贝：序列化反序列化方式比较通用，采用递归一直处理没有引用类型，比较繁琐
         * @param object
         * @return
         * @throws Exception
         */
        public Object deepCopy(Object object) throws Exception {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(object);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return oi.readObject();
        }
    }
}
