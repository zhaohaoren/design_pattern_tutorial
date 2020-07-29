package mediator;

/**
 * 同事类：那些交互关系的类2
 *
 * @author zhaohaoren
 */
public class Colleague2 extends Colleague {
    public Colleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void op() {
        System.out.println("i am 2");
    }
}
