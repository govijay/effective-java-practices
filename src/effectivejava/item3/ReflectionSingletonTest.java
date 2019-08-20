package effectivejava.item3;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {

    public static void main(String[] args) {
        EagerSingleton eagerSingleton1 =  EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = null;

        try {

            Constructor[] constructors = EagerSingleton.class.getDeclaredConstructors();

            for (Constructor c : constructors) {
                c.setAccessible(true);
                eagerSingleton2 = (EagerSingleton)c.newInstance();

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(eagerSingleton1.hashCode());
        System.out.println(eagerSingleton2.hashCode());
    }
}
