package singleton;

/**
 * 饿汉式
 * -
 * 线程安全
 * 优点：简单还线程安全
 * 缺点：不是懒加载的，有时候可能造成没必要的开销：比如系统中有大量的单例，很多不一定用的上的。
 * -
 *
 * @author zhaohaoren
 */
public class EagerSingleton {
    //2: 内置一个单例对象
    private static final EagerSingleton singleton = new EagerSingleton();

    //1: 构造函数私有化
    private EagerSingleton() {
    }

    //3: 提供静态方法获取数据
    public static EagerSingleton getInstance() {
        return singleton;
    }
}
