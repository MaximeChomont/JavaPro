import inject.annotations.Inject;
import inject.IOC;
import modele.Cascade.inter.ICascade;
import modele.Personne.inter.IPersonne;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InjectTest {

    @Inject
    IPersonne personne;

    IPersonne personne2;

    @Inject
    ICascade myCascade;

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

    @Test
    public void testCascade() {
        Assert.assertNotNull(myCascade);
        Assert.assertNotNull(myCascade.getPersonne());
    }

    //Si pas d'implémentation
    //Si trop d'implémentation et pas de @prefered
}