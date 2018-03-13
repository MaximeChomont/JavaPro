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

    @Override
    public Object getBean() {
        return bean;
    }

    @Override
    public Method getMethod() {
        return method;
    }
    @Override
    public Object[] getArgs() {
        return args;
    }

    @Override
    public Object nextInterceptor() {
        try {
            return interceptors[index++].invoke(this);
        } finally{
            index--;
        }
    }
}
