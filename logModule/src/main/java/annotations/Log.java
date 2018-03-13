package annotations;

import inject.annotations.CDIBehavior;
import interceptor.LogInterceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@CDIBehavior(cdiInterceptor = LogInterceptor.class)
public @interface Log {
}
