import inject.annotations.Inject;
import inject.IOC;
import inject.annotations.SingletonQualifier;
import modele.Group.impl.GroupSingleton;
import modele.Group.inter.IGroup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QualifierTest {
    @Inject
    @SingletonQualifier
    IGroup groupSingleton;

    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    //Test que l'implémentation ayant @singletonQualifier soit bien injecté
    //@Test
    public void testQualifierSuccess() {
        Assert.assertNotNull(groupSingleton);
        Assert.assertEquals(groupSingleton.getClass(), GroupSingleton.class);
    }
}
