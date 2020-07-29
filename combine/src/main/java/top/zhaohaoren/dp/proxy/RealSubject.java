package top.zhaohaoren.dp.proxy;

/**
 * 真实主题角色
 *
 * @author zhaohaoren
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("subject is working...");
    }
}
