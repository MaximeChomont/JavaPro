import inject.IOC;
import inject.annotations.Inject;
import modele.impl.TransactionTest;
import modele.impl.TransactionnalObject;
import modele.inter.ITransaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TransactionnalTest {

    @Inject
    TransactionTest transaction;

    @Inject
    TransactionnalObject transactionnalObject;

    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
        transaction.reset();
    }

    @Test
    public void testTransactionnalSuccess() {
        transactionnalObject.businessLogic();
        Assert.assertTrue(transaction.isBeginWorked());
        Assert.assertTrue(transaction.isCommitWorked());
        Assert.assertFalse(transaction.isRollbackWorked());
    }
    @Test
    public void testTransactionnalFailure() {
        try {
            transactionnalObject.businessLogicWithErrors();
        } catch(Exception e) {

        }
        finally {
            Assert.assertTrue(transaction.isBeginWorked());
            Assert.assertTrue(transaction.isRollbackWorked());
            Assert.assertFalse(transaction.isCommitWorked());
        }
    }
}
