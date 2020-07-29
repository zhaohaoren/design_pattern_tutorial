package builder;

/**
 * 构造器模式demo
 *
 * @author zhaohaoren
 */
public class BuilderDemo {

    public static void main(String[] args) {
        CarBuilder builder = new BigCarBuilder();
        //具体使用哪个builder来构造对象，可以使用配置文件来配置，增加灵活度。
        Director director = new Director(builder);
        Car car = director.build();
        System.out.println(car);
    }
}
