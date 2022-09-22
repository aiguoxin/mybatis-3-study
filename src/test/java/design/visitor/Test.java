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
