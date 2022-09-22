package design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 9/21/22 15:31
 * aiguoxin 
 * 说明: 读取不同资源文件pdf、ppt等
 */
public class First {
    public static void main(String[] args) {
        List<ResourceFile> list = new ArrayList<>();
        list.add(new PdfFile("....."));
        list.stream().forEach(ResourceFile::extract2txt);
    }


    static abstract class ResourceFile {
        protected String filePath;

        public ResourceFile(String filePath) {
            this.filePath = filePath;
        }

        public abstract void extract2txt();

        /***
         * 如果再需要增加额外的其他功能，如：压缩等，则需要改抽象类及实现类，实现类容易💥（仅当操作非常多的时候，考虑使用）
         * 使用访问者模式如何解决：分离资源与操作？？？？？
         * 哪些框架使用了观察者模式？？？
         */
    }

    static class PdfFile extends ResourceFile {

        public PdfFile(String filePath) {
            super(filePath);
        }

        @Override
        public void extract2txt() {
            System.out.println("extract pdfFile");
        }

    }
}
