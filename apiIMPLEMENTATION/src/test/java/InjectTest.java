import inject.annotations.Inject;
import inject.IOC;
import modele.Group.impl.GroupCascade;
import modele.Personne.inter.IPersonne;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InjectTest {

    @Inject
    IPersonne personne;

    IPersonne personne2;

    @Inject
    GroupCascade groupCascade;

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
    public void testCascade() { Assert.assertNotNull(groupCascade.getGroup());}

    //Si pas d'implémentation
    //Si trop d'implémentation et pas de @prefered
}