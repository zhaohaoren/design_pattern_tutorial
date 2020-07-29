package mediator;

/**
 * 中介者模式demo
 *
 * @author zhaohaoren
 */
public class MediatorDemo {
    public static void main(String[] args) {
        //定义中介者
        ConcreteMediator concreteMediator = new ConcreteMediator();
        //定义同事
        Colleague1 colleague1 = new Colleague1(concreteMediator);
        Colleague2 colleague2 = new Colleague2(concreteMediator);
        //同事注册到中介者上
        concreteMediator.register(colleague1);
        concreteMediator.register(colleague2);
        //触发改动
        colleague1.send();
        colleague2.send();
    }
}
