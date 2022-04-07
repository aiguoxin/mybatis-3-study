package java8.solid.is;

/**
 * 2022/4/6 下午4:40
 * aiguoxin 
 * 说明:
 */
public class Good {

}

interface Printer{
    void print();
}

interface Fax{
    void fax();
}

class AllInOnePrinterG implements Printer,Fax{

    @Override
    public void print() {

    }

    @Override
    public void fax() {

    }
}

class EconomicPrinterG implements Printer{

    @Override
    public void print() {
    }
}