package top.zhaohaoren.dp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 安全的组合模式
 *
 * @author zhaohaoren
 */
public class SafeCompositeDemo {
    public static void main(String[] args) {
        ComponentSafe c1, c2, c3;
        c1 = new LeafSafe("1");
        c2 = new LeafSafe("2");
        c3 = new LeafSafe("3");
        CompositeSafe f1, f2, f3;
        f1 = new CompositeSafe("1");
        f2 = new CompositeSafe("2");
        f3 = new CompositeSafe("3");
        //build
        f1.add(c1);
        f1.add(c2);
        f1.add(c3);
        f2.add(f3);
        f1.add(f2);
        f1.operation();

    }
}

class LeafSafe implements ComponentSafe {
    private String name;

    public LeafSafe(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("叶子：" + name);
    }
}

class CompositeSafe implements ComponentSafe {
    private String name;
    private List<ComponentSafe> componentSafeList = new ArrayList<>();

    public CompositeSafe(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("非叶子节点" + name);
        componentSafeList.forEach(ComponentSafe::operation);
    }

    public void add(ComponentSafe c) {
        componentSafeList.add(c);
    }

    public void remove(ComponentSafe c) {
        componentSafeList.remove(c);
    }

    public List<ComponentSafe> getChild() {
        return componentSafeList;
    }
}