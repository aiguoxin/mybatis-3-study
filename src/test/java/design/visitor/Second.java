package design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 9/21/22 15:42
 * aiguoxin 
 * 说明:
 */
public class Second {
    public static void main(String[] args) {
        List<First.ResourceFile> list = new ArrayList<>();
        list.add(new First.PdfFile("....."));

        //这么编译会报错，ResourceFile中增加accept方法解决
//        list.stream().forEach(Extractor::extract2txt);
    }


    static class Extractor{
        public static void extract2txt(PdfFile pdfFile){
            System.out.println("extract pdf...");
        }
    }


    static abstract class ResourceFile {
        protected String filePath;

        public ResourceFile(String filePath) {
            this.filePath = filePath;
        }

        public abstract void accept(Extractor extractor);

        /**
         * 再增加一个操作，再来一个类似的？
         * public abstract void accept(Compressor compressor);
         */
    }

    static class PdfFile extends ResourceFile {

        public PdfFile(String filePath) {
            super(filePath);
        }

        @Override
        public void accept(Extractor extractor) {
            extractor.extract2txt(this);
        }

    }
}