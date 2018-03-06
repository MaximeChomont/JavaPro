import inject.annotations.interceptor.ICDIInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BeanInvocationHandler implements InvocationHandler {
    private Object bean;
    private ICDIInterceptor[] interceptors;

    public BeanInvocationHandler(Object bean, ICDIInterceptor[] interceptors) {
        this.bean = bean;
        this.interceptors = interceptors;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(bean, interceptors, method, args);
        return invocation.nextInterceptor();
    }
}
