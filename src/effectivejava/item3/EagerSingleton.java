package effectivejava.item3;

public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    // private constructor to avoid client applications to use constructor.
    private EagerSingleton(){

    }

    public static EagerSingleton getInstance(){
        SecurityManager manager = new SecurityManager();

        System.setSecurityManager(manager);
        return instance;
    }

}

class EagerSingletonMain {

    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        System.out.println(eagerSingleton.hashCode());

        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton1.hashCode());
    }
}

