package mediator;

import java.util.ArrayList;

/**
 * 抽象中介者
 *
 * @author zhaohaoren
 */
public abstract class Mediator {

    /**
     * 维系着同事对象的引用
     */
    protected ArrayList<Colleague> colleagues = new ArrayList<>();

    /**
     * 往中介者中添加同事对象
     */
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    /**
     * 中介的关系逻辑
     */
    public abstract void operation(Colleague colleague);
}
