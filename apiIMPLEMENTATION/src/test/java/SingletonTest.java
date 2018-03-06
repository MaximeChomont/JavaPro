import impl.BeanInvocationHandler;
import inject.annotations.Inject;
import inject.IOC;
import inject.annotations.Prefered;
import inject.annotations.SingletonQualifier;
import modele.Group.inter.IGroup;

import modele.Group.inter.IGroup2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class SingletonTest {
    @Inject
    IGroup group;

    @Inject
    IGroup group2;

    @Inject
    IGroup2 groupSingleton;

    @Inject
    IGroup2 groupSingleton2;


    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    //Injection de deux implémentations ayant @singleton, on test si c'est la même instance
    @Test
    public void testSingletonSuccess() {
        Assert.assertNotNull(groupSingleton);
        Assert.assertNotNull(groupSingleton2);
        Assert.assertSame(((BeanInvocationHandler)Proxy.getInvocationHandler(groupSingleton)).getBean(), ((BeanInvocationHandler)Proxy.getInvocationHandler(groupSingleton2)).getBean());
    }

    //les deux implémentations ne doivent pas avoir la même instance
    @Test
    public void testSingletonFailure() {
        Assert.assertNotNull(group);
        Assert.assertNotNull(group2);
        Assert.assertNotSame(group, group2);
    }
}
