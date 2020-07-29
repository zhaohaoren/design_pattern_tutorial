package memento;

/**
 * 原发器类
 *
 * @author zhaohaoren
 */
public class Originator {
    private String state;

    /**
     * 创建一个备忘录对象
     */
    public Memento createMemento() {
        return new Memento(this);
    }

    /**
     * 根据备忘录对象恢复到之前的状态。
     */
    public void restoreMemento(Memento m) {
        state = m.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
