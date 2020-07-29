package observer;

import java.util.ArrayList;

/**
 * 抽象目标类
 *
 * @author zhaohaoren
 */
public abstract class AllyControlCenter {
    /**
     * 战队名
     */
    protected String allyName;
    /**
     * 存储观察者的集合
     */
    protected ArrayList<Observer> players = new ArrayList<>();


    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }


    /**
     * 注册方法，对目标类添加新的观察者
     */
    public void join(Observer obs) {
        System.out.println(obs.getName() + " join " + allyName);
        players.add(obs);
    }

    /**
     * 注销方法：移除观察者
     */
    public void quit(Observer obs) {
        System.out.println(obs.getName() + " leave " + allyName);
        players.remove(obs);
    }

    /**
     * 抽象通知方法，通知所有的观察者
     */
    public abstract void notifyObserver(String name);


}
