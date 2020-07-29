package singleton;

/**
 * 懒汉式
 * -
 * 线程不安全，需要处理线程安全
 * 处理：
 * 方法加同步锁
 * 优点：方便
 * 缺点：并发访问效率差，完全串行化。
 * -
 *
 * @author zhaohaoren
 */
public class LazySingleton {

    //1: 内置单例对象引用
    private static LazySingleton singleton = null;

    //2: 构造函数私有化
    private LazySingleton() {
    }

    //3: 提供获取对象的静态方法
    synchronized public static LazySingleton getInstance() {
        // 判断如果还没有创建就先创建
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
