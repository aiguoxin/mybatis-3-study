/**
 *    Copyright 2009-2021 the original author or authors.
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
package java8;

import java.io.*;

/** 2021/3/25 下午9:31 aiguoxin 说明: 序列化漏洞练习
* https://paper.seebug.org/312/
* */
public class SerializableTest {
    public static void main(String args[]) throws Exception {
        // 定义myObj对象
        MyObject myObj = new MyObject();
        myObj.name = "hi";
        // 创建一个包含对象进行反序列化信息的”object”数据文件
        FileOutputStream fos = new FileOutputStream("object");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        // writeObject()方法将myObj对象写入object文件
        os.writeObject(myObj);
        os.close();
        // 从文件中反序列化obj对象
        FileInputStream fis = new FileInputStream("object");
        ObjectInputStream ois = new ObjectInputStream(fis);
        // 恢复对象
        MyObject objectFromDisk = (MyObject) ois.readObject();
        System.out.println(objectFromDisk.name);
        ois.close();
    }
}

class MyObject implements Serializable {
    public String name;
    // 重写readObject()方法
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        // 执行默认的readObject()方法
        in.defaultReadObject();
        // 执行打开计算器程序命令
        Runtime.getRuntime().exec("open /Applications/Calculator.app/");
    }
}
