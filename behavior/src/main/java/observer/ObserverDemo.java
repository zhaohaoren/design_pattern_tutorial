package observer;

/**
 * 观察者模式
 *
 * @author zhaohaoren
 */
public class ObserverDemo {
    public static void main(String[] args) {
        //创建需要被观察的目标对象
        ConcreteAllyControlCenter team = new ConcreteAllyControlCenter("team1");
        //定义四个观察者
        Observer player1, player2, player3, player4;
        player1 = new Player("A");
        team.join(player1);
        player2 = new Player("B");
        team.join(player2);
        player3 = new Player("C");
        team.join(player3);
        player4 = new Player("D");
        team.join(player4);
        //让某一个遭受攻击
        player2.beAttacked(team);
    }
}
