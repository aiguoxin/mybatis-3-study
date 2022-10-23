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
package design.memento;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

/**
 * 9/22/22 16:49
 * aiguoxin 
 * 说明: 备忘录也称快照模式
 */
public class SnapShot {

    static class InputText {
        StringBuilder text = new StringBuilder();

        public String toString() {
            return text.toString();
        }

        public void addText(String content) {
            text.append("\n").append(content);
        }

        public SnapText createSnap() {
            return new SnapText(text.toString());
        }

        public void restore(SnapText snapText) {
            this.text.replace(0, this.text.length(), snapText.text);
        }
    }

    static class SnapText {
        private String text;

        public SnapText(String text) {
            this.text = text;
        }
    }

    static class SnapHolder {
        Stack<SnapText> stack = new Stack<>();

        public void addSnap(SnapText snapText) {
            stack.push(snapText);
        }

        public SnapText popSnap() {
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapHolder snapHolder = new SnapHolder();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (Objects.equals(":list", input)) {
                System.out.println(inputText.toString());
            } else if (Objects.equals(":undo", input)) {
                SnapText snapText = snapHolder.popSnap();
                inputText.restore(snapText);
            } else if (Objects.equals(":exit", input)) {
                System.exit(-1);
            } else {
                snapHolder.addSnap(inputText.createSnap());
                inputText.addText(input);
            }
        }
    }
}
