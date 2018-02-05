import inject.annotations.Alternative;
import inject.IOC;
import inject.annotations.Inject;
import modele.Personne.impl.PersonneAlternative;
import modele.Personne.inter.IPersonne;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlternativeTest {

    @Inject
    @Alternative
    IPersonne personne;

    @Inject
    IPersonne personne2;

    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    @Test
    public void testAlternativeSuccess() {
        Assert.assertEquals(personne.getClass(), PersonneAlternative.class);
    }
}
