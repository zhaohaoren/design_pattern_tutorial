package builder;

/**
 * 具体构建类1：大车构建类
 *
 * @author zhaohaoren
 */
public class BigCarBuilder extends CarBuilder {
    @Override
    public void buildLight() {
        this.car.setLight("big light");
    }

    @Override
    public void buildWheel() {
        this.car.setWheel("big wheel");
    }

    @Override
    public void buildChair() {
        this.car.setChair("big chair");
    }
}
