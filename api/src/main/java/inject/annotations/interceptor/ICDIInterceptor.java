package inject.annotations.interceptor;
import inject.inter.IInvocation;

public interface ICDIInterceptor {
    /**
     * @param invocation invocation qui sera utilisée pour appliquer la chaîne d'interceptors
     * @return retour de l'appel de l'invocation
     */
    public Object invoke(IInvocation invocation);
}
