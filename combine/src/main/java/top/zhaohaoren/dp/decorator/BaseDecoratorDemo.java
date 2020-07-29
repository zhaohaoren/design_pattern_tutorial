package top.zhaohaoren.dp.decorator;

/**
 * 装饰模式-透明装饰模式使用
 *
 * @author zhaohaoren
 */
public class BaseDecoratorDemo {
    public static void main(String[] args) {
        Component c1 = new ComponentA();
        Component c2 = new ComponentDecoratorA(c1);
        Component c3 = new ComponentDecoratorB(c2);
        c3.display();
    }
}
