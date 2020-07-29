package mediator;

/**
 * 具体中介者
 *
 * @author zhaohaoren
 */
public class ConcreteMediator extends Mediator {
    @Override
    public void operation(Colleague colleague) {
        //这里将注册的同事类的关系联系起来
        //这里只是瞎写了一个逻辑。
        if (colleague == colleagues.get(0)) {
            colleague.op();
            colleagues.get(1).op();
        } else {
            colleagues.get(1).op();
            colleague.op();
        }
    }
}
