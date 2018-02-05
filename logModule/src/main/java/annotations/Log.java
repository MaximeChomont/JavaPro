package annotations;

import inject.annotations.CDIBehavior;
import interceptor.LogInterceptor;

@CDIBehavior(cdiInterceptor = LogInterceptor.class)
public @interface Log {
}
