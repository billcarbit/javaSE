package proxy.staticproxy;

/**
 * 代理律师
 */
public class ProxyLawyer implements GoToCourt {

    private Wangning mWangning;

    public ProxyLawyer() {
        mWangning = new Wangning();
    }

    @Override
    public void execute() {
        talkDetails();
        mWangning.execute();
        defend();
    }

    private void defend(){
        System.out.println("为委托人进行辩护");
    }

    private void talkDetails(){
        System.out.println("和委托人详细交谈");
    }
}
