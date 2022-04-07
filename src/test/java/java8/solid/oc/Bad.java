package java8.solid.oc;

/**
 * 2022/4/6 下午4:17
 * aiguoxin 
 * 说明: 开闭原则例子
 */
public class Bad {
    public void doHandler(Adapter adapter){
        if(adapter instanceof AjaxAdapter){
            makeAjaxCall();
        }else if(adapter instanceof NodeAdapter){
            makeNodeCall();
        }
    }

    private void makeNodeCall() {
        //
    }

    private void makeAjaxCall() {
        //
    }
}

abstract class Adapter {

}

class AjaxAdapter extends Adapter{

}

class NodeAdapter extends Adapter{

}
