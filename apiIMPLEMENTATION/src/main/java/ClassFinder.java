import inject.annotations.Prefered;
import org.reflections.Reflections;

import java.util.Set;

public class ClassFinder {
    public static <T> Class<? extends T> search(Class<T> classToSearch, Reflections reflection) throws Exception{
        Class<? extends T> result = null;
        if(classToSearch.isInterface()){
            Set<Class<? extends T>> implementations =  reflection.getSubTypesOf(classToSearch);
            result = managePrefered(implementations);
            if(result == null){
                manageInject(implementations);
            }
        }
        return  result;
    }
    private static <T> Class<? extends T> managePrefered(Set<Class<? extends T>> implementations) throws Exception{
        Class<? extends T> result = null;
        int nbPreferedImpl = 0;
        for(Class<? extends T> implementation : implementations){
            if (implementation.isAnnotationPresent(Prefered.class)) {
                result = implementation;
                ++nbPreferedImpl;
            }
        }
        if(nbPreferedImpl > 1){

        }
        return result;
    }
    private  static <T> Class<? extends T> manageInject(Set<Class<? extends T>> implementations) throws Exception{
        Class<? extends T> result = null;
        if(!implementations.isEmpty()) {
            if (implementations.size() == 1) {
                result = implementations.iterator().next();
            } else {

            }
        } else {

        }
        return result;
    }
}
