package top.zhaohaoren.dp.flyweight;

/**
 * 享元抽象
 *
 * @author zhaohaoren
 */
public interface Flyweight {
    /**
     * 内部变化
     */
    void printIntrinsicState();

    /**
     * @param extrinsicState 外部变化 让外部来控制
     */
    void op(String extrinsicState);
}
