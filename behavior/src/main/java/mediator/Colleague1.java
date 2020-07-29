package mediator;

/**
 * 同事类：那些交互关系的类1
 *
 * @author zhaohaoren
 */
public class Colleague1 extends Colleague{

    public Colleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void op() {
        System.out.println("i am 1");
    }
}
