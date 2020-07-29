package top.zhaohaoren.dp.flyweight;

/**
 * 具体享元类2
 *
 * @author zhaohaoren
 */
public class ConcreteFlyweight2 implements Flyweight {


    @Override
    public void printIntrinsicState() {
        System.out.println("intrinsicState2");
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
