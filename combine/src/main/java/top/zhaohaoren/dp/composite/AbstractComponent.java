package top.zhaohaoren.dp.composite;

import java.util.List;

/**
 * 缺省适配器
 *
 * @author zhaohaoren
 */
public abstract class AbstractComponent implements Component {

    @Override
    public void add(Component c) {
        System.out.println("no support");
    }

    @Override
    public void remove(Component c) {
        System.out.println("no support");
    }

    @Override
    public List<Component> getChild() {
        System.out.println("no support");
        return null;
    }

    @Override
    public abstract void operation();
}
