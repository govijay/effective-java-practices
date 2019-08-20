package effectivejava.item3;

public class LazyInitialization {

    private static LazyInitialization instance;

    private LazyInitialization(){}

    public static /*synchronized*/ LazyInitialization getInstance(){
        if(instance == null){
            instance = new LazyInitialization();
        }
        return instance;
    }
}
/*
// works fine for single threaded system but breaks singleton pattern in multithread system. not thread safe.
class LazyInitializationTest {
    public static void main(String[] args) {
        System.out.println(LazyInitialization.getInstance());
        System.out.println(LazyInitialization.getInstance());
    }
}
*/

// Singleton breaks when multiple thread invokes the getInstance();

class LazyInitializationClient implements Runnable {

    @Override
    public void run() {

        try {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running");
            System.out.println(LazyInitialization.getInstance().hashCode());
        }catch (Exception e){
            System.out.println("Exception is caught");
        }

    }
}

class LazyInitializationClientMain {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(new LazyInitializationClient());
            thread.start();
            
        }
    }
}

