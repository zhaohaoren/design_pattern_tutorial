package top.zhaohaoren.dp.proxy;



import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyInterceptor implements MethodInterceptor {

    private Object object;

    public ProxyInterceptor(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("invoke cglib proxy");
        if ("request".equals(method.getName())) {
            System.out.println("invoke request method [cglib]");
            methodProxy.invokeSuper(o, args);
        } else {
            System.out.println("调用的其他方法");
            methodProxy.invokeSuper(o, args);
        }
        return null;
    }
}
