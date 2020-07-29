package singleton;

/**
 * Initialization on Demand Holder 单例模式
 * -
 * 优点：线程安全，懒加载
 * 缺点：看重语言，不同语言可能不支持该单例
 *
 * @author zhaohaoren
 */
public class IoDHSingleton {

    //1: 构造私有化
    private IoDHSingleton() {
    }

    //2: 静态内部类
    private static class HolderClass {
        private final static IoDHSingleton instance = new IoDHSingleton();
        /*
         * 利用了java的类加载机制：
         * 加载IoDHSingleton的时候不会初始化HolderClass，而是在getInstance的时候才会加载。
         * */
    }

    //3: 静态方法
    public static IoDHSingleton getInstance() {
        return HolderClass.instance;
    }


    public static void main(String[] args) {
        IoDHSingleton s1 = IoDHSingleton.getInstance();
        IoDHSingleton s2 = IoDHSingleton.getInstance();
        System.out.println(s1 == s2);
    }
}
