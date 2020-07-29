package top.zhaohaoren.dp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 透明的组合模式
 *
 * @author zhaohaoren
 */
public class TransparentCompositeDemo {
    public static void main(String[] args) {
        Component c1, c2, c3, f1, f2, f3;
        c1 = new Leaf("1");
        c2 = new Leaf("2");
        c3 = new Leaf("3");
        f1 = new Composite("1");
        f2 = new Composite("2");
        f3 = new Composite("3");
        f1.add(c1);
        f1.add(c2);
        f2.add(f1);
        f3.add(c3);
        f1.add(f3);
        f1.operation();
    }
}


class Leaf implements Component {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {
        System.out.println("can't add");
    }

    @Override
    public void remove(Component c) {
        System.out.println("can't remove");
    }

    @Override
    public List<Component> getChild() {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("叶子节点：" + name);
    }
}


class Composite implements Component {

    private List<Component> componentList = new ArrayList<>();
    private String name;

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {
        componentList.add(c);
    }

    @Override
    public void remove(Component c) {
        componentList.remove(c);
    }

    @Override
    public List<Component> getChild() {
        return componentList;
    }

    @Override
    public void operation() {
        System.out.println("非叶子节点：" + name);
        componentList.forEach(Component::operation);
    }
}