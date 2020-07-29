package responsibility;

/**
 * 具体处理类B
 *
 * @author zhaohaoren
 */
public class ConcreteHandlerB extends AbstractHandler {
    @Override
    public void handleRequest(String request) {
        if ("B".equals(request)) {
            System.out.println("i am B");
        } else {
            if (next == null) {
                System.out.println("no handler");
                return;
            }
            this.next.handleRequest(request);
        }
    }
}
