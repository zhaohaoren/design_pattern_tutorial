package factory;

/**
 * 简单工厂模式
 *
 * @author zhaohaoren
 */
public class SimpleFactory {
    // 静态工厂方法
    public static Product getProduct(String name) {
        switch (name.toLowerCase()) {
            case "a":
                return new ProductA();
            case "b":
                return new ProductB();
            default:
                return null;
        }
    }

    // 这里当成客户端：我们添加一个工厂类来创建对象。
    public static void main(String[] args) {
        //可以从配置文件来配置获取什么对象
        SimpleFactory.getProduct("a").printName();
    }
}

// 所有工厂里面的产品，抽象一个接口。便于产品的扩展不会影响到工厂类和客户端类去改动。
interface Product {
    void printName();
}

// 产品A
class ProductA implements Product {

    // 创建和打印职责交给自己的产品类
    public ProductA() {
        System.out.println("create A");
    }

    @Override
    public void printName() {
        System.out.println("i am A");
    }
}

// 产品B
class ProductB implements Product {

    public ProductB() {
        System.out.println("create B");
    }

    @Override
    public void printName() {
        System.out.println("i am B");
    }
}
