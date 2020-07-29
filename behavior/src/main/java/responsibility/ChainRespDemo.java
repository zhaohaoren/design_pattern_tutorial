package responsibility;

/**
 * @author zhaohaoren
 */
public class ChainRespDemo {
    public static void main(String[] args) {
        AbstractHandler a, b;
        a = new ConcreteHandlerA();
        b = new ConcreteHandlerB();
        //初始化链条结构: a->b
        a.setNext(b);
        //请求
        a.handleRequest("A");
        a.handleRequest("B");
        a.handleRequest("C");
    }
}
