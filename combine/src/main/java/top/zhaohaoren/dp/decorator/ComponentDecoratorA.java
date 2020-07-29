package top.zhaohaoren.dp.decorator;

/**
 * 装饰器的具体实现类A
 *
 * @author zhaohaoren
 */
public class ComponentDecoratorA extends ComponentDecorator {

    public ComponentDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void display() {
        System.out.println("装饰A--开始");
        super.display();
        System.out.println("装饰A--结束");
    }
}
