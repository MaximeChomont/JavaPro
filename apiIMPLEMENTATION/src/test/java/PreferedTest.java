import inject.annotations.Inject;
import inject.IOC;
import modele.Group.impl.Group;
import modele.Group.inter.IGroup;
import modele.Personne.inter.IPersonne;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PreferedTest {
    @Inject
    IGroup group;

    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    //On test que le group @prefered soit  bien injecté
    @Test
    public void testPreferedSuccess() {
        Assert.assertNotNull(group);
        Assert.assertEquals(group.getClass(), Group.class);
    }
}
