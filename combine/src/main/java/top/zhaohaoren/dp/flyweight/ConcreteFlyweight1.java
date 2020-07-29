package top.zhaohaoren.dp.flyweight;

/**
 * 具体享元类1
 *
 * @author zhaohaoren
 */
public class ConcreteFlyweight1 implements Flyweight {


    /**
     * 这个内部状态 就是该对象能被享元的分到的最小细粒度了。在这种状态下，系统需要多少个对象就要创建多少这样的享元类。
     */
    @Override
    public void printIntrinsicState() {
        System.out.println("intrinsicState1");
    }

    /**
     * 显示外部变化
     */
    @Override
    public void op(String extrinsicState) {
        printIntrinsicState();
        System.out.println(extrinsicState);
    }
}
