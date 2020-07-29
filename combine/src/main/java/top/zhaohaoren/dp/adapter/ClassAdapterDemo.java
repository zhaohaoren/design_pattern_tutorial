package top.zhaohaoren.dp.adapter;

/**
 * 类适配器模式
 *
 * @author zhaohaoren
 */
public class ClassAdapterDemo {
    public static void main(String[] args) {
        ITarget base = null;
        // 这个部分可以使用配置文件来可配置
        base = new ClassAdapter();
        base.userFunction();
    }
}


/**
 * 区别就是适配器 是继承了被适配者而不是关联。
 */
class ClassAdapter extends Adaptee implements ITarget {

    @Override
    public void userFunction() {
        this.adapteeFunction();
    }
}
