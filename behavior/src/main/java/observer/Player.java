package observer;

public class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println(name + " help you!");
    }

    @Override
    public void beAttacked(AllyControlCenter acc) {
        System.out.println(name + " is attacked!");
        acc.notifyObserver(name);
    }
}
