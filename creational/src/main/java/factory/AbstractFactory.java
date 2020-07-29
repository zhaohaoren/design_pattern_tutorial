package factory;

/**
 * 抽象工厂
 *
 * @author zhaohaoren
 */
public class AbstractFactory {
    public static void main(String[] args) {
        IAbstractFactory factory = new Factory1Impl();
        Product_A a = factory.createA();
        Product_B b = factory.createB();
        a.printName();
        b.printName();
    }
}

// 产品族工厂抽象
interface IAbstractFactory {
    Product_A createA();

    Product_B createB();
}

// 产品族为1的所有产品
class Factory1Impl implements IAbstractFactory {

    @Override
    public Product_A createA() {
        return new ProductA1();
    }

    @Override
    public Product_B createB() {
        return new ProductB1();
    }
}

// 产品族为2的所有产品
class Factory2Impl implements IAbstractFactory {

    @Override
    public Product_A createA() {
        return new ProductA2();
    }

    @Override
    public Product_B createB() {
        return new ProductB2();
    }
}


//A1 A2 和 A 是不同的产品等级
interface Product_A {
    void printName();
}

//A1 B1 是产品族
class ProductA1 implements Product_A {

    @Override
    public void printName() {

    }
}

class ProductA2 implements Product_A {

    @Override
    public void printName() {

    }
}

interface Product_B {
    void printName();
}

class ProductB1 implements Product_B {

    @Override
    public void printName() {

    }
}

class ProductB2 implements Product_B {

    @Override
    public void printName() {

    }
}