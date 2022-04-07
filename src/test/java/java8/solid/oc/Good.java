package java8.solid.oc;

/**
 * 2022/4/6 下午4:22
 * aiguoxin 
 * 说明:
 */
public class Good {
    private AdapterG adapterG;
    public Good(AdapterG adapterG){
        this.adapterG = adapterG;
    }

    public void doHandler(AdapterG adapterG){
        adapterG.doHandle();
    }
}

abstract class AdapterG{
    abstract void doHandle();
}

class AjaxAdapterG extends AdapterG{
    @Override
    void doHandle() {
        //
    }
}

class NodeAdapterG extends AdapterG{
    @Override
    void doHandle() {
        //
    }
}
