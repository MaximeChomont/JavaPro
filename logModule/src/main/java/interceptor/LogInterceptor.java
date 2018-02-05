package interceptor;

import inject.annotations.Inject;
import inject.annotations.interceptor.ICDIInterceptor;
import modele.inter.ILogger;

public class LogInterceptor implements ICDIInterceptor {
    @Inject
    ILogger logger;

    public void before(){
        logger.before();
    }
    public void after(){
        logger.after();
    }
}
