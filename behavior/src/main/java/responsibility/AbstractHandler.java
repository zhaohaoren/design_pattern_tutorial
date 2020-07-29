package responsibility;

/**
 * 抽象处理类
 *
 * @author zhaohaoren
 */
public abstract class AbstractHandler {
    //下一个处理引用
    protected AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public abstract void handleRequest(String request);
}
