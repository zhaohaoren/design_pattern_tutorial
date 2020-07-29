package top.zhaohaoren.dp.flyweight;

/**
 * @author zhaohaoren
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        Flyweight f1 = FlyweightFactory.getInstance().getFlyweight("1");
        Flyweight f2 = FlyweightFactory.getInstance().getFlyweight("2");
        f1.op("you are one");
        f1.op("you are not one");
        f2.op("you are two");
    }
}