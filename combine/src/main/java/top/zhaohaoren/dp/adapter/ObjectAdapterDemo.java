package top.zhaohaoren.dp.adapter;

/**
 * 典型的一个适配器模式
 * 也可以说是对象适配器模式
 *
 * @author zhaohaoren
 */
public class ObjectAdapterDemo {
    public static void main(String[] args) {
        // 模仿客户端使用，都是面向接口编程的
        ITarget base = null;
        // 这个部分可以使用配置文件来可配置
        base = new ObjectAdapter(new Adaptee());
        // 这时候调用的方法就是被适配的类的方法了
        base.userFunction();

    }
}


/**
 * 适配器
 * 对象适配器模式，内持一个被适配者的对象
 */
class ObjectAdapter implements ITarget {
    /**
     * 内组合一个被适配的对象
     */
    Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void userFunction() {
        adaptee.adapteeFunction();
    }
}