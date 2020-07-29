package observer;

/**
 * 具体目标类
 *
 * @author zhaohaoren
 */
public class ConcreteAllyControlCenter extends AllyControlCenter {

    public ConcreteAllyControlCenter(String name) {
        this.allyName = name;
        System.out.println("create team:" + name);
    }

    @Override
    public void notifyObserver(String name) {
        System.out.println("notify all friends! " + name + " is attacked!");
        for (Observer player : players) {
            // 调用除了自己以外的盟友
            if (!player.getName().equalsIgnoreCase(name)) {
                player.help();
            }
        }
    }
}
