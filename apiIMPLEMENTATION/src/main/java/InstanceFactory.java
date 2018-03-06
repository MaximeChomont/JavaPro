import inject.annotations.Singleton;
import inject.inter.IInjectionSystem;

import java.util.HashMap;

public class InstanceFactory {

    private static HashMap<Class<?>, Object> singletonsClass = new HashMap<>();

    public static Object create(Class<?> impl, IInjectionSystem injectionSystem) throws Exception {
        Object instance = null;

        if(impl.isAnnotationPresent(Singleton.class)) {
            if(!singletonsClass.containsKey(impl)){
                instance = impl.newInstance();
                injectionSystem.inject(instance);
                singletonsClass.put(impl,instance);
            } else {
                instance = singletonsClass.get(impl);
            }
        } else {
            instance = impl.newInstance();
            injectionSystem.inject(instance);
        }
        return instance;
    }
}
