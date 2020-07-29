package factory;

/**
 * 工厂方法模式，又叫（工厂模式，虚拟构造器模式，多态工厂模式）
 *
 * @author zhaohaoren
 */
public class MethodFactory {
    // 模拟客户端使用
    public static void main(String[] args) {
        // 具体使用哪个工厂类，我们可以再配置文件里配置然后读取，不一定在这里写死。
        ProductFactory factory = new AProductFactory();
        Product product = factory.getProduct();
        product.printName();
    }
}


interface ProductFactory {
    Product getProduct();
}

class AProductFactory implements ProductFactory {

    @Override
    public Product getProduct() {
        return new ProductA();
    }
}

class BProductFactory implements ProductFactory {

    @Override
    public Product getProduct() {
        return new ProductB();
    }
}


