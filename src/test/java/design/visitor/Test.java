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
package design.visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 9/21/22 16:49
 * aiguoxin 
 * 说明: 访问者模式框架中应用
 */
public class Test {

    @org.junit.Test
    public void testFile() throws IOException {
        Files.walkFileTree(Paths.get("/Users/liuruixue/Downloads"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.println("\t正在访问" + file + "文件");
                return FileVisitResult.CONTINUE; // 没找到继续找
            }
        });
    }


    /**
     * ASM应用，具体见{@link study.bytecode.ASMGenerator}
     */


    /***
     * antlr ：https://github.com/antlr/antlr4
     */
}
