package top.zhaohaoren.dp.decorator;

/**
 * 装饰器的具体实现类B
 *
 * @author zhaohaoren
 */
public class ComponentDecoratorB extends ComponentDecorator {

    public ComponentDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void display() {
        System.out.println("装饰B--开始");
        super.display();
        System.out.println("装饰B--结束");
    }
}
