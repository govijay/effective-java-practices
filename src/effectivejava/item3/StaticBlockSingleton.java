package effectivejava.item3;

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    // static block initialization for exception handling.
    static {
        try{
            instance = new StaticBlockSingleton();
        }catch (Exception e){
            throw new RuntimeException("Exception occurred while creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}


class StaticBlockSingletonMain {
    public static void main(String[] args) {

        StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getInstance();
        System.out.println("First Instance call " + staticBlockSingleton.hashCode());

        StaticBlockSingleton staticBlockSingleton1 = StaticBlockSingleton.getInstance();
        System.out.println("Second Instance call " + staticBlockSingleton1.hashCode());
    }
}