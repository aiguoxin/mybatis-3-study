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
 * 9/21/22 15:55
 * aiguoxin 
 * 说明:
 */
public class Last {
    public static void main(String[] args) {
        List<ResourceFile> list = new ArrayList<>();
        list.add(new PdfFile("....."));

        //这么编译会报错，ResourceFile中增加accept方法解决
//        list.stream().forEach(Extractor::extract2txt);

        for (ResourceFile resourceFile : list) {
            /***新增操作时，只需新增操作类即可，不用改动每个资源类!!!**/
            resourceFile.accept(new Extractor());
        }
    }


    interface Visitor{
        void visit(PdfFile pdfFile);
    }

    static class Extractor implements Visitor{
        @Override
        public void visit(PdfFile pdfFile) {
            System.out.println("extract pdf file");
        }
    }


    static abstract class ResourceFile {
        protected String filePath;

        public ResourceFile(String filePath) {
            this.filePath = filePath;
        }

        public abstract void accept(Visitor visitor);

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
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

    }
}
