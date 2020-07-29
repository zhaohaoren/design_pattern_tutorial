package observer;

/**
 * 抽象观察者类
 *
 * @author zhaohaoren
 */
public interface Observer {
    String getName();

    void setName(String name);

    /**
     * 帮助队友的方法
     */
    void help();

    /**
     * 申明遭受攻击的方法，即观察者观察到了后，通知哪些对象
     */
    void beAttacked(AllyControlCenter acc);
}
