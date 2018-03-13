package inject.inter;

import java.lang.reflect.Method;

public interface IInvocation {
    public Object nextInterceptor();
    public Object getBean();
    public Method getMethod();
    public Object[] getArgs();
}
