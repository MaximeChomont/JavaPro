package impl;

import inject.annotations.Inject;
import inject.inter.IInjectionSystem;

import java.lang.reflect.Field;

public class MyInjectionSystem implements IInjectionSystem {

    MyContainer myContainer;


    @Override
    public void inject(Object o) throws Exception{
        MyContainer myContainer = MyContainer.getMyContainerInstance();
        Class<? extends Object> classContext = o.getClass();
        Field[] fields = classContext.getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(Inject.class)){
                Object instance = myContainer.createBean(field.getType());
                field.setAccessible(true);
                field.set(o, instance);
            }
        }
    }
}
