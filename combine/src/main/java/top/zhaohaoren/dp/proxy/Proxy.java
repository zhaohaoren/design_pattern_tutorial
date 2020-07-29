package top.zhaohaoren.dp.proxy;

/**
 * 代理角色
 *
 * @author zhaohaoren
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    public void preRequest() {
        System.out.println("prepare...");
    }

    @Override
    public void request() {
        preRequest();
        subject.request();
        postRequest();
    }

    public void postRequest() {
        System.out.println("finish...");
    }
}
