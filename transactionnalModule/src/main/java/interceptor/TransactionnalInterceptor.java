package interceptor;

import inject.annotations.Inject;
import inject.annotations.interceptor.ICDIInterceptor;
import modele.inter.ITransaction;

public class TransactionnalInterceptor implements ICDIInterceptor {

    @Inject
    ITransaction transaction;

    public void begin() {
        transaction.begin();
    }
    public void commit() {
        transaction.commit();
    }
    public void rollback() {
        transaction.rollback();
    }
}
