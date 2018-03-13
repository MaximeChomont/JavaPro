package impl;

import inject.IOC;
import inject.annotations.interceptor.ICDIInterceptor;
import inject.inter.IInjectionSystem;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

import java.lang.reflect.Proxy;
import java.util.*;

public class MyContainer {
    private Map<Class<?>, Class<?>> registry;
    private List<ICDIInterceptor> interceptors;
    private Reflections reflection;
    private static MyContainer myContainerInstance = null;

    private MyContainer() {
        this.reflection = new Reflections("");
        this.registry = new HashMap<Class<?>, Class<?>>();
        this.interceptors = new ArrayList<ICDIInterceptor>();

    }

    public static MyContainer getMyContainerInstance() {
        if(myContainerInstance == null) {
            myContainerInstance = new MyContainer();
            try {
                for(Class<? extends ICDIInterceptor> object : myContainerInstance.reflection.getSubTypesOf(ICDIInterceptor.class)){
                    if(object.equals(BeanInterceptor.class)) {
                        myContainerInstance.interceptors.add((ICDIInterceptor) object.newInstance());
                    } else {
                        myContainerInstance.interceptors.add(0,(ICDIInterceptor) object.newInstance());
                    }

                }
                for (ICDIInterceptor o : myContainerInstance.interceptors) {
                    IOC.inject(o);
                }
            } catch (Exception e){

            }
        }
        return myContainerInstance;
    }

    public <T> MyContainer register(Class<? extends T> impl, Class<T> iface) {
        registry.put(iface, impl);
        return this;
    }

    public <T> T createBean(Class<T> iface) {
        try {
            Class<? extends T> impl;
            if(registry.containsKey(iface)){
                impl = (Class<? extends T>) registry.get(iface);
            } else {
                impl = ClassFinder.search(iface, reflection);
                registry.put(iface,impl);
            }
            BeanInvocationHandler handler = new BeanInvocationHandler(
                    InstanceFactory.create(impl), interceptors.toArray(new ICDIInterceptor[]{}));
            return (T) Proxy.newProxyInstance(
                    Thread.currentThread().getContextClassLoader(),
                    new Class[] {iface},
                    handler);
        } catch (Exception e) {
            //throw new ContainerException(e.getMessage());
            return null;
        }
    }
}