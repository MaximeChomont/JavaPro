package interceptor;

import annotations.Log;
import inject.annotations.Inject;
import inject.annotations.interceptor.ICDIInterceptor;
import inject.inter.IInvocation;
import modele.inter.ILogger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class LogInterceptor implements ICDIInterceptor {
    @Inject
    ILogger logger;

    public void before(){
        logger.before();
    }
    public void after(){
        logger.after();
    }

    @Override
    public Object invoke(IInvocation invocation) {
        Method method = invocation.getMethod();
        Object object = invocation.getBean();
        Annotation[] annotations = object.getClass().getDeclaredAnnotations();
        /*
        for(Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }
        annotations = method.getDeclaredAnnotations();
        for(Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }
        System.out.println(method.isAnnotationPresent(Log.class));
        try {
            annotations = object.getClass().getMethod(method.getName()).getDeclaredAnnotations();
            for(Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(object.getClass().isAnnotationPresent(Log.class));
        */
        Object result = null;
        if (method.isAnnotationPresent(Log.class)|| object.getClass().isAnnotationPresent(Log.class)) {
            before();
            result = invocation.nextInterceptor();
            after();
        } else {
            result = invocation.nextInterceptor();
        }
        return result;
    }
}
