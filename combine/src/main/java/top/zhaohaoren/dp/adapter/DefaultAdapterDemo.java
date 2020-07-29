package top.zhaohaoren.dp.adapter;

/**
 * 缺省适配器模式（不是默认哦）
 *
 * @author zhaohaoren
 */
public class DefaultAdapterDemo {
    public static void main(String[] args) {
        ServiceInterface serviceInterface = new Service1();
        serviceInterface.f1();
        serviceInterface.f2();
    }
}

/**
 * 一个很多方法的接口
 */
interface ServiceInterface {
    void f1();

    void f2();

    void f3();

    void f4();
}

/**
 * 缺省适配器
 * 使用抽象类适配一版本，提供接口默认实现
 */
abstract class AbastractServiceClass implements ServiceInterface {
    @Override
    public void f1() {
        System.out.println("abs f1");
    }

    @Override
    public void f2() {
        System.out.println("abs f2");
    }

    @Override
    public void f3() {
        System.out.println("abs f3");
    }

    @Override
    public void f4() {
        System.out.println("abs f4");
    }
}

/**
 * 对应具体业务去实现对应的接口方法即可。
 */
class Service1 extends AbastractServiceClass {
    @Override
    public void f1() {
        System.out.println("service 1");
    }
}

class ServiceN extends AbastractServiceClass {
    @Override
    public void f4() {
        System.out.println("service 4");
    }
}