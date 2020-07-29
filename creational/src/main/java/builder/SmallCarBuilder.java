package builder;

/**
 * 具体构建类2：小车构建类
 *
 * @author zhaohaoren
 */
public class SmallCarBuilder extends CarBuilder {
    @Override
    public void buildLight() {
        this.car.setLight("small light");
    }

    @Override
    public void buildWheel() {
        this.car.setWheel("small wheel");
    }

    @Override
    public void buildChair() {
        this.car.setChair("small chair");
    }
}
