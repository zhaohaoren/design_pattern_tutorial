package top.zhaohaoren.dp.flyweight;

/**
 * 非共享具体享元类
 *
 * @author zhaohaoren
 */
public class UnsharedConcreteFlyweight implements Flyweight {

    /**
     * 不是享元内部的那些状态。
     */
    private String otherStates;

    @Override
    public void printIntrinsicState() {
        System.out.println("intrinsicState");
    }

    @Override
    public void op(String extrinsicState) {
        //输出内部状态
        printIntrinsicState();
        //输出其他的状态
        System.out.println(otherStates);
        //输出外部控制的状态
        System.out.println(extrinsicState);
    }
}
