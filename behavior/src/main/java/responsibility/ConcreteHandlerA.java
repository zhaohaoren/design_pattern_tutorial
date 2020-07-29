package responsibility;

/**
 * 具体处理类A
 *
 * @author zhaohaoren
 */
public class ConcreteHandlerA extends AbstractHandler {
    @Override
    public void handleRequest(String request) {
        if ("A".equals(request)) {
            System.out.println("i am A");
        } else {
            if (next == null) {
                System.out.println("no handler");
                return;
            }
            this.next.handleRequest(request);
        }
    }
}
