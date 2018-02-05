import inject.annotations.Inject;
import inject.annotations.Prefered;
import inject.IOC;
import modele.Personne.impl.PersonnePrefered;
import modele.Personne.inter.IPersonne;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PreferedTest {
    @Inject
    @Prefered
    IPersonne personne;

    @Inject
    IPersonne personne2;

    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    @Test
    public void testPreferedSuccess() {
        Assert.assertEquals(personne.getClass(), PersonnePrefered.class);
    }
}
