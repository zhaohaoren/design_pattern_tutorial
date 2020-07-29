package top.zhaohaoren.dp.adapter;

/**
 * 被适配的类
 *
 * @author zhaohaoren
 */
public class Adaptee implements IAdaptee {
    @Override
    public void adapteeFunction() {
        // 客户端使用方 想要调用的方法
        System.out.println("adaptee function");
    }
}
