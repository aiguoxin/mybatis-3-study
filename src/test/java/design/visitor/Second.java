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