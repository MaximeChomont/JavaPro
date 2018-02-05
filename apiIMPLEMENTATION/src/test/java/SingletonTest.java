import inject.annotations.Alternative;
import inject.annotations.Inject;
import inject.IOC;
import inject.annotations.Prefered;
import modele.Group.inter.IGroup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingletonTest {
    @Inject
    IGroup groupSingleton;

    @Inject
    @Alternative
    IGroup groupNoneSingleton;

    @Inject
    @Prefered
    IGroup groupSingleton2;

    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    @Test
    public void testSingletonSuccess() {
        Assert.assertSame(groupSingleton, groupSingleton2);
    }

    @Test
    public void testSingletonFailure() {
        Assert.assertNotSame(groupSingleton, groupNoneSingleton);
    }
}
