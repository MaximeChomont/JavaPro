package modele.impl;

import inject.annotations.Singleton;
import modele.inter.ITransaction;

@Singleton
public class TransactionTest implements ITransaction{
    private boolean beginWorked = false;
    private boolean commitWorked = false;
    private boolean rollbackWorked = false;

    public TransactionTest() {

    }
    /*GETTERS*/

    public boolean isBeginWorked() {
        return beginWorked;
    }

    public boolean isCommitWorked() {
        return commitWorked;
    }

    public boolean isRollbackWorked() {
        return rollbackWorked;
    }
    /*SETTERS*/

    public void setBeginWorked(boolean beginWorked) {
        this.beginWorked = beginWorked;
    }

    public void setCommitWorked(boolean commitWorked) {
        this.commitWorked = commitWorked;
    }

    public void setRollbackWorked(boolean rollbackWorked) {
        this.rollbackWorked = rollbackWorked;
    }
    /*METHODS*/

    @Override
    public void begin() {
        beginWorked = true;
    }

    @Override
    public void commit() {
        commitWorked = true;
    }

    @Override
    public void rollback() {
        rollbackWorked = true;
    }

    public void reset() {
        beginWorked = false;
        commitWorked = false;
        rollbackWorked = false;
    }
}
