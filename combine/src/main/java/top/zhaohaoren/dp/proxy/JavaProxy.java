package top.zhaohaoren.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * java动态代理
 *
 * @author zhaohaoren
 */
public class JavaProxy implements InvocationHandler {

    private Subject subject;

    public JavaProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke java proxy");
        if ("request".equals(method.getName())) {
            System.out.println("invoke request method");
            return method.invoke(subject, args);
        } else {
            System.out.println("调用的其他方法");
            return method.invoke(subject, args);
        }
    }
}


