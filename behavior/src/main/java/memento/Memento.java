package memento;

/**
 * 备忘录类
 * 注意这里包的访问级别，是包权限。阻止包外类是用该备忘录。
 *
 * @author zhaohaoren
 */
class Memento {

    private String state;

    Memento(Originator originator) {
        state = originator.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
