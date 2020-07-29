package memento;

/**
 * 备忘录模式
 *
 * @author zhaohaoren
 */
public class MementoDemo {

    public static void main(String[] args) {
        // 创建负责人
        Caretaker caretaker = new Caretaker();
        Originator o = new Originator();
        o.setState("1");
        // 创建一个备忘录对象，保存状态，并初始化负责人的备忘录对象
        caretaker.setMemento(o.createMemento());
        o.setState("2");
        System.out.println(o.getState());
        // 恢复
        o.restoreMemento(caretaker.getMemento());
        System.out.println(o.getState());
    }
}
