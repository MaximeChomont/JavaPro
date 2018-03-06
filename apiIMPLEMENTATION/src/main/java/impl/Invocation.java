package impl;

import inject.annotations.interceptor.ICDIInterceptor;
import inject.inter.IInvocation;

import java.lang.reflect.Method;

public class Invocation implements IInvocation {
    private Object bean;
    private ICDIInterceptor[] interceptors;
    private Method method;
    private Object[] args;
    private int index;

    public Invocation(Object bean, ICDIInterceptor[] interceptors, Method method, Object[] args) {
        this.bean = bean;
        this.interceptors = interceptors;
        this.method = method;
        this.args = args;
    }

    public Object getBean() {
        return bean;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    public Object nextInterceptor() {
        try {
            return interceptors[index++].invoke(this);
        } finally {
            index--;
        }
    }
}
