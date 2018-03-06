package inject;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

import java.lang.reflect.Method;

public class IOC {
    public static void inject(Object o){

        /*
        Reflections reflexion = new Reflections( ClasspathHelper.forClass(Object.class),
                new SubTypesScanner(false));
        for( Method method : o.getClass().getMethods()) {
            MethodAnnotationsScanner
        }
        */
        //SPI RECHERCHE DANS META INF L4IMPL IInjectionSystem
    }
}
