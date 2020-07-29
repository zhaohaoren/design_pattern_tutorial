package builder;

/**
 * 将创建的流程和客户端隔离的指挥类
 *
 * @author zhaohaoren
 */
public class Director {

    /**
     * 构造者模式第二个关键点：
     * 指挥类里面内持一个builder，让客户端只在乎使用哪个builder来构建就行。
     * 通过这样客户端就完全只需要知道自己用哪个builder就行了，然后初始化好builder直接往指挥类里面塞。
     */
    public CarBuilder builder;

    public Director(CarBuilder builder) {
        this.builder = builder;
    }

    public CarBuilder getBuilder() {
        return builder;
    }

    /**
     * 构建对象
     */
    public Car build() {
        builder.buildLight();
        builder.buildWheel();
        builder.buildChair();
        return builder.createCar();
    }
}
