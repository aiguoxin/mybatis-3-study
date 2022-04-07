package java8.solid.is;

/**
 * 2022/4/6 下午4:36
 * aiguoxin 
 * 说明: 接口隔离原则
 */
public class Bad {

}

interface SmartPrinter {
    void print();
    void fax();
}

class AllInOnePrinter implements SmartPrinter {
    @Override
    public void print() {
    }

    @Override
    public void fax() {
    }
}

class EconomicPrinter implements SmartPrinter {

    @Override
    public void print() {

    }

    @Override
    public void fax() {
        throw new RuntimeException("not supported");
    }
}
