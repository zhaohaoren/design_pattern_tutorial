package top.zhaohaoren.dp.proxy;

/**
 * 代理模式
 *
 * @author zhaohaoren
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Subject s = new Proxy(new RealSubject());
        s.request();
        System.out.println("------");

        //JDK动态代理
        Subject real = new RealSubject();
        JavaProxy proxy = new JavaProxy(real);
        Subject proxyClass = (Subject) java.lang.reflect.Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, proxy);
        proxyClass.request();
    }
}
