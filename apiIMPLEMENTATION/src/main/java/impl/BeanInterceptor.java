package impl;

import inject.annotations.interceptor.ICDIInterceptor;
import inject.exception.InvocationException;
import inject.inter.IInvocation;

import java.lang.reflect.Method;

public class BeanInterceptor implements ICDIInterceptor {
    @Override
    public Object invoke(IInvocation invocation) {
        try {
            Object bean = invocation.getBean();
            Method method = invocation.getMethod();
            Object[] args = invocation.getArgs();
            return method.invoke(bean, args);
        } catch (Exception e) {
            throw new InvocationException(e.getMessage());
        }
    }
}
