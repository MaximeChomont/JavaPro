package inject;

import inject.exception.NoImplementationFoundException;
import inject.exception.NoInjectionSystemException;
import inject.inter.IInjectionSystem;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.ServiceLoader;

public class IOC {
    public static void inject(Object o) throws Exception{

        ServiceLoader<IInjectionSystem> injectionLoader = ServiceLoader.load(IInjectionSystem.class);
        Iterator<IInjectionSystem> injectionIterator = injectionLoader.iterator();
        if(injectionIterator.hasNext()){

            injectionIterator.next().inject(o);

        } else {
            throw new NoInjectionSystemException();
        }
    }
}
