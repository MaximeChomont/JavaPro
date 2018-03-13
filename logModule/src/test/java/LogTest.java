import inject.IOC;
import inject.annotations.Inject;
import modele.impl.LoggerTest;
import modele.inter.ILogClassTest;
import modele.inter.ILogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;

public class LogTest {
    @Inject
    ILogger logger;

    @Inject
    ILogClassTest logClassTest;

    @Before
    public void setUp() throws Exception {
        IOC.inject(this);
    }

    @Test
    public void testLogSuccess() {
        logClassTest.logMethod();
        Class cls = logClassTest.getClass();
        Annotation[] annotations = cls.getAnnotations();
        Annotation[] annotations2 = cls.getDeclaredAnnotations();
        Assert.assertTrue(LoggerTest.isBeforeWorked());
        Assert.assertTrue(LoggerTest.isAfterWorked());
    }
}
