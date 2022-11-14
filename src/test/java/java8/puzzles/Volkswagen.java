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
package java8.puzzles;

import java.lang.reflect.Field;
import java.util.HashSet;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

/**
 * 10/28/22 16:04
 * aiguoxin 
 * 说明: https://www.javaspecialists.eu/archive/Issue199-Hacking-Java-Surreptitiously.html
 */
public class Volkswagen {
    public static int counter = 0;
    public static Volkswagen vw = new Volkswagen();

    private static final int CAPACITY = 5;
    private HashSet<Clown> clowns = new HashSet<Clown>();

    public synchronized void add(Clown clown) {
        if (clowns.size() >= CAPACITY) {
            throw new IllegalStateException("I'm full");
        } else {
            clowns.add(clown);
        }
    }

    public synchronized boolean done() {
        if (clowns.size() == 20) {
            // The goal is to reach this line
            System.out.println("I'm a Volkswagen with 20 clowns!");
            return true;
        }
        return false;
    }


    /**
     * 起始状态，汽车限制了5人，但是如何突破限制，可以乘坐20人？
     */
    @Test
    public void init() {
        // TODO put 20 clowns into a Volkswagen
        Volkswagen vw = new Volkswagen();
        for (int i = 0; i < 20; i++) {
            vw.add(new Clown());
        }
        vw.done();
    }

    @Test
    public void solution() {
        Volkswagen.vw.add(new RecursiveClown());
        Volkswagen.vw.done();
    }

    /**
     * 使用反射解决
     * -Djava.security.manager 加上这个参数后，如果使用setAccessible方法会报错
     * Exception in thread "main" java.security.AccessControlException: access denied ("java.util.PropertyPermission" "idea.is.junit5" "read")
     */
    @Test
    public void reflection() {
        HashSet<Clown> clowns = new HashSet<Clown>();
        for (int i = 0; i < 20; i++) {
            clowns.add(new Clown());
        }

        Volkswagen vw = new Volkswagen();
        Field field = ReflectionUtils.findField(Volkswagen.class, "clowns");
        field.setAccessible(true);
        ReflectionUtils.setField(field, vw, clowns);
        vw.done();
    }
}

class Clown {
}

class RecursiveClown extends Clown {
    /**HashSet底层使用HashMap，使用put方法，会调用hashCode函数**/
    public int hashCode() {
        if (++Volkswagen.counter < 20) {
            Volkswagen.vw.add(new RecursiveClown());
        }
        return super.hashCode();
    }
}