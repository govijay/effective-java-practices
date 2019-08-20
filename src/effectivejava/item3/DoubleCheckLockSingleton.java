package effectivejava.item3;

public class DoubleCheckLockSingleton {

    private static DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton(){}

    public static DoubleCheckLockSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckLockSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }
}


class DoubleCheckLockSingletonClient implements Runnable {

    @Override
    public void run() {

        try {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running");
            System.out.println(DoubleCheckLockSingleton.getInstance().hashCode());
        }catch (Exception e){
            System.out.println("Exception is caught");
        }

    }
}

class DoubleCheckLockSingletonClientMain {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(new DoubleCheckLockSingletonClient());
            thread.start();

        }
    }
}
