import inject.inter.IInjectionSystem;

import java.lang.reflect.Field;

public class MyInjectionSystem implements IInjectionSystem {

    MyContainer myContainer;

    public void MyInjectionSystem(){
        myContainer = new MyContainer(this);
    }

    @Override
    public void inject(Object o) {
        o.getClass().getDeclaredAnnotations();
        for(Field f :o.getClass().getFields()){
            f.getAnnotations();
            f.getClass().getAnnotations();
        }
    }
}
