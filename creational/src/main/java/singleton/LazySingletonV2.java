package singleton;

/**
 * 懒汉式V2 - 双重检查锁定（double check locking）
 * -
 * 线程不安全，需要处理线程安全
 * 处理：
 * 减小同步代码块的范围
 * 优点：并发性能只能说 比代码块整体同步要高，但是效率也不是很完美。
 * 缺点：代码较复杂
 * -
 *
 * @author zhaohaoren
 */
public class LazySingletonV2 {

    //1: 内置单例对象引用
    //6: 因为线程可见性，需要使用volatile修饰。
    private volatile static LazySingletonV2 singleton = null;

    //2: 构造函数私有化
    private LazySingletonV2() {
    }

    //3: 提供获取对象的静态方法
    public static LazySingletonV2 getInstance() {
        //4: 第一重判断
        if (singleton == null) {
            synchronized (LazySingletonV2.class) {
                //5: 第二重判断
                /*
                 * 我们可以将同步块先缩小到创建对象这个语句上；
                 * 但是线程依然是不安全的，可能创建多个单例：
                 * t1 t2 两个线程 可能都判断singleton为null，进入了创建代码的同步块中，这样还会创建多个。
                 * 所以在同步块中，再次判断下是否上个线程已经创建好了。
                 */
                if (singleton == null) {
                    singleton = new LazySingletonV2();
                }
            }
        }
        return singleton;
    }
}
