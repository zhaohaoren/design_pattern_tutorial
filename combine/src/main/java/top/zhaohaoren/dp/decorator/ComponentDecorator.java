package top.zhaohaoren.dp.decorator;

/**
 * 装饰器的抽象类
 *
 * @author zhaohaoren
 */
public abstract class ComponentDecorator implements Component {
    private Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
