package top.zhaohaoren.dp.composite;

import java.util.List;

/**
 * 透明组合模式抽象
 *
 * @author zhaohaoren
 */
public interface Component {
    void add(Component c);

    void remove(Component c);

    List<Component> getChild();

    void operation();
}
