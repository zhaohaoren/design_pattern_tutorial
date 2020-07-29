package builder;

/*
 * 进一步简化：
 * 一个没有指挥类Director的构建器
 * 可以将Director和Builder进行合并。加重Builder的职责
 */

/**
 * builder抽象
 */
abstract class CarBuilder2 {
    protected Car car = new Car();

    public abstract void buildLight();

    public abstract void buildWheel();

    public abstract void buildChair();

    /**
     * 这个可以是一个静态方法
     *
     * @return
     */
    public Car build() {
        this.buildWheel();
        this.buildChair();
        this.buildLight();
        return car;
    }
}


public class NoDirectorCarBuilder extends CarBuilder2 {
    @Override
    public void buildLight() {
        this.car.setLight("no director light");
    }

    @Override
    public void buildWheel() {
        this.car.setWheel("no director wheel");
    }

    @Override
    public void buildChair() {
        this.car.setChair("no director chair");
    }


    public static void main(String[] args) {
        NoDirectorCarBuilder builder = new NoDirectorCarBuilder();
        Car car = builder.build();
        System.out.println(car);
    }
}

