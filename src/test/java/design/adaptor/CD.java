package design.adaptor;

/**
 * 7/27/22 20:36
 * aiguoxin 
 * 说明: CD是外部类，不能修改，包含static方法，不便单测
 * 采用的extends方式
 */
public class CD {
    public static void staticMethod(){

    }
}

interface ITarget{
    void M1();
}

class CDAdaptor extends CD implements ITarget{

    @Override
    public void M1() {
        super.staticMethod();
    }
}
