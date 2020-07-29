package builder;

/**
 * 抽象Builder
 *
 * @author zhaohaoren
 */
public abstract class CarBuilder {

    /**
     * 这个内置car对象很关键！所有的builder模式构建对象的时候都是用的这个car，这样就完全隔离了客户端和car之间的联系
     */
    Car car = new Car();

    public abstract void buildLight();

    public abstract void buildWheel();

    public abstract void buildChair();

    /**
     * 这个可以是一个静态方法
     * @return
     */
    public Car createCar() {
        return car;
    }
}
