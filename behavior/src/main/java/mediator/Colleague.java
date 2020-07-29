package mediator;

/**
 * 抽象同事类
 *
 * @author zhaohaoren
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 同事自己的方法，一般也是其他同事所耦合的向要调用的方法。
     */
    public abstract void op();

    /**
     * 自己定义依赖方法，与中介者进行通信
     */
    public void send() {
        mediator.operation(this);
    }
}
