package java8;

/**
 * 5/11/22 16:40
 * aiguoxin 
 * 说明:
 */
public class MockInterface {
    //私有构造方法
    protected MockInterface(){
    }
    //抛出运行时异常，强制子类覆盖
    public void testMethod(){
        throw new RuntimeException();
    }

}
