import inject.annotations.Inject;
import inject.IOC;
import inject.annotations.Prefered;
import inject.annotations.SingletonQualifier;
import modele.Group.inter.IGroup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingletonTest {
    @Inject
    IGroup group;

    @Inject
    @SingletonQualifier
    IGroup groupSingleton;

    @Inject
    @SingletonQualifier
    IGroup groupSingleton2;


    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    //Injection de deux implémentations ayant @singleton, on test si c'est la même instance
    @Test
    public void testSingletonSuccess() {
        Assert.assertSame(groupSingleton, groupSingleton2);
    }

    //les deux implémentations ne doivent pas avoir la même instance
    @Test
    public void testSingletonFailure() {
        Assert.assertNotSame(groupSingleton, group);
    }
}
