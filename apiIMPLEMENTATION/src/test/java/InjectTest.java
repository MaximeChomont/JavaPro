import inject.annotations.Inject;
import inject.IOC;
import modele.Personne.inter.IPersonne;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InjectTest {

    @Inject
    IPersonne personne;

    IPersonne personne2;

    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    @Test
    public void testInjectionSuccess() {
        Assert.assertNotNull(personne);
    }

    @Test
    public void testInjectionFailure() {
        Assert.assertNull(personne2);
    }
}