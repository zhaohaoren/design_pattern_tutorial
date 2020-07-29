package top.zhaohaoren.dp.adapter;

/**
 * 双向适配器模式
 *
 * @author zhaohaoren
 */
public class TwoWayAdapterDemo {

    public static void main(String[] args) {
        // 客户端使用
        ITarget target = new TwoWayAdapter(new Adaptee());
        target.userFunction();
        // 反过来 适配器使用
        IAdaptee adaptee = new TwoWayAdapter((ITarget) () -> System.out.println("target function"));
        adaptee.adapteeFunction();
    }

}

class TwoWayAdapter implements IAdaptee, ITarget {

    private IAdaptee adaptee;
    private ITarget target;

    public TwoWayAdapter(IAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    public TwoWayAdapter(ITarget target) {
        this.target = target;
    }

    /**
     * 给客户端用
     * 可以作为为客户端 适配的适配器
     */
    @Override
    public void adapteeFunction() {
        target.userFunction();
    }

    /**
     * 给被适配类用，被适配的类成了客户端
     * 也可以作为为被适配器类 适配了客户端
     */
    @Override
    public void userFunction() {
        adaptee.adapteeFunction();
    }
}
