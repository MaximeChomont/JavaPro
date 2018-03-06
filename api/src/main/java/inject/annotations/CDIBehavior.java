package inject.annotations;

import inject.annotations.interceptor.ICDIInterceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Proxy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CDIBehavior {
    Class<? extends ICDIInterceptor> cdiInterceptor();
}
