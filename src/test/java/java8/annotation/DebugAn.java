package java8.annotation;

import org.junit.Test;

/**
 * 1/9/23 19:38
 * aiguoxin 
 * 说明:
 * 1.注解的父类java.lang.annotation.Annotation,通过命令行javap -c -v Count.class 或者通过AMS可视化查看字节码
 * 注解是接口，继承了接口Annotation
 * 2.所有注解类的实现，都是AnnotationInvocationHandler生成动态代理类
 *getAnnotation()->annotationData()->createAnnotationData()->AnnotationParser.parseAnnotations->parseAnnotations2()
 * ->annotationForMap()——>AnnotationInvocationHandler动态代理
 *
 *
 * 参考：https://www.cnblogs.com/throwable/p/9747595.html
 */

@Count(count = 1)
public class DebugAn {

    @Test
    public void test() {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Count count = DebugAn.class.getAnnotation(Count.class);
        System.out.println(count.count());
    }
}
