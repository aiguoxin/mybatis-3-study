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

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 2020/8/8 下午4:54
 * aiguoxin
 * 说明:
 */
public class ASMGenerator {

    public static void main(String[] args) throws Exception {
        ClassReader classReader = new ClassReader("study/bytecode/ASMBase");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor,ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();

        File f = new File("/Users/liuruixue/Downloads/mybatis源码与脑图/mybatis-3-master/target/test-classes/study/bytecode/ASMBase.class");
//        FileOutputStream fout = new FileOutputStream(f);
//        fout.write(data);
//        fout.close();
        try(FileOutputStream out =  new FileOutputStream(f)){
            out.write(data);
        }

        Class<?> clz = Class.forName("study.bytecode.ASMBase");
        ASMBase asmBase = (ASMBase) clz.newInstance();
        asmBase.process();
    }
}
