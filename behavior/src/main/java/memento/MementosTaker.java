package memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 保存多个备忘录的管理者。这样可以实现多次撤销
 *
 * @author zhaohaoren
 */
public class MementosTaker {
    private List<Memento> mementos = new ArrayList<>();

    public Memento getMemento(int index) {
        return mementos.get(index);
    }

    public void setMementos(Memento memento) {
        this.mementos.add(memento);
    }
}
