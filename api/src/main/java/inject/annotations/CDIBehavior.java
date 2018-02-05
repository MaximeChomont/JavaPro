package inject.annotations;

import inject.annotations.interceptor.ICDIInterceptor;

public @interface CDIBehavior {
    Class<? extends ICDIInterceptor> cdiInterceptor();
}
