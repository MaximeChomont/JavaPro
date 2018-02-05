import inject.annotations.Qualifier;
import inject.IOC;
import modele.Personne.inter.IPersonne;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QualifierTest {
    @Qualifier
    IPersonne personne;

    IPersonne personne2;

    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    @Test
    public void testQualifierSuccess() {
        Assert.assertNotNull(personne);
    }
}
